package com.onezero.crawler;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.onezero.datastructure.GenericResult;
import com.onezero.downloader.NowCoderDownloader;
import com.onezero.entity.nowcoder.*;
import com.onezero.parse.NowCoderParser;
import com.onezero.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.*;

@Component
public class NowCoderCrawler implements ICrawler{
    private static Logger logger = LoggerFactory.getLogger(NowCoderCrawler.class);

    private static final String DETAIL_URL = "https://m.nowcoder.com/kaoyan/detail/%s?client=4&order=year&asc=0&fm=ios_app_3.0.0";

    private static final String PC_HOST = "https://www.nowcoder.com";
    private static final String INFO_URL = "https://www.nowcoder.com/kaoyan/detail/%s/%s?page=";

    @Autowired
    private NowCoderDownloader nowCoderDownloader;
    @Autowired
    private NowCoderParser nowCoderParser;



    @Override
    public void execute(Map<String, Object> params) {
        String url = (String) params.get("url");
        if (StringUtils.isEmpty(url)) {
            logger.info("params: {}, nowCoder crawl error", params);
            return;
        }
        try {
            HttpResponse response = nowCoderDownloader.get(url);
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
            Type type = new TypeToken<NowCoderResult<Schools>>() {
            }.getType();
            NowCoderResult<Schools> schools = new Gson().fromJson(s, type);
            if (schools.getCode() != 0) {
                return;
            }
            /**
             * 获取考研学校id
             */
            List<Integer> schoolIds = new ArrayList<>();
            List<SchoolArea> areas = schools.getData().getSchools();
            for (SchoolArea area : areas) {
                List<SchoolItem> items = area.getSchools();
                for (SchoolItem item : items) {
                    schoolIds.add(item.getSchoolId());
                }
            }

            /**
             * 获取考研学校对应的试卷列表
             */
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (Integer schoolId : schoolIds) {
                String u = String.format(DETAIL_URL, schoolId);
                HttpResponse resp = nowCoderDownloader.get(u);
                NowCoderResult<Paper> result = (NowCoderResult<Paper>) nowCoderParser.parseJson(EntityUtils.toString(resp.getEntity()), new TypeToken<NowCoderResult<Paper>>() {
                }.getType());
                map.put(schoolId, new ArrayList<>());
                if (result.getCode() == 0) {
                    List<Dep> deps = result.getData().getDeps();
                    for (Dep dep : deps) {
                        map.get(schoolId).add(dep.getId());
                    }
                }
                Thread.sleep(500);
            }

            map.forEach((key, value) -> {
                for (Integer id : value) {
                    String u = String.format(INFO_URL, key, id);
                    try {
                        HttpResponse resp = nowCoderDownloader.get(u);
                        PaperInfo paperInfo = new PaperInfo();
                        String html = EntityUtils.toString(resp.getEntity());
                        nowCoderParser.getPaperInfo(html, paperInfo);
                        for (int i = 2; i <= paperInfo.getPageNum(); i++) {
                            resp = nowCoderDownloader.get(u + i);
                            html = EntityUtils.toString(resp.getEntity());
                            nowCoderParser.getPaperInfo(html, paperInfo);
                        }
                        for (int i = 0; i < paperInfo.getQuestions().size(); i++) {
                            resp = nowCoderDownloader.get(PC_HOST + paperInfo.getQuestions().get(i));
                            nowCoderParser.parseHtml(resp);
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        logger.error("url: {}", u);
                    }
                }
            });

        } catch (Exception e) {
            logger.error("url: {}",url, e);
        }

    }
}
