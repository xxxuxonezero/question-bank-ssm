package com.onezero.crawler;

import com.onezero.dal.TagMapper;
import com.onezero.dal.data.TagData;
import com.onezero.downloader.LOJDownloader;
import com.onezero.entity.loj.*;
import com.onezero.mongo.OJQuestionDal;
import com.onezero.mongo.data.OJQuestionData;
import com.onezero.mongo.data.OJSectionData;
import com.onezero.mongo.data.SampleData;
import com.onezero.parse.LOJParser;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LOJCrawler implements ICrawler{
    @Autowired
    private LOJDownloader lojDownloader;
    @Autowired
    private LOJParser lojParser;
    @Autowired
    private OJQuestionDal ojQuestionDal;
    @Autowired
    private TagMapper tagMapper;

    public static final String pageUrl = "https://api.loj.ac.cn/api/problem/queryProblemSet";
    public static final String detailUrl = "https://api.loj.ac.cn/api/problem/getProblem";
    public static final Integer PAGE_SIZE = 100;

    @Override
    public void execute(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        int totalCount = 0;
        List<Integer> ids = new ArrayList<>();
        map.put("locale", "zh_CN");
        map.put("skipCount", 0);
        map.put("takeCount", PAGE_SIZE);
        HttpResponse response = lojDownloader.post(pageUrl, map);
        LOJQuestionPageInfo pageInfo = (LOJQuestionPageInfo) lojParser.parseJson(response, LOJQuestionPageInfo.class);
        if (pageInfo != null) {
            totalCount = pageInfo.getCount();
            List<LOJQuetionItem> items = pageInfo.getResult();
            if (CollectionUtils.isNotEmpty(items)) {
                List<Integer> list = items.stream().filter(item -> item.getMeta() != null).map(item -> item.getMeta().getDisplayId()).collect(Collectors.toList());
                ids.addAll(list);
            }
        }
//        handleDetail(ids);
//        ids.clear();
        for (int i = 13; i <= totalCount / PAGE_SIZE; i++) {
            map.put("skipCount", i * PAGE_SIZE);
            response = lojDownloader.post(pageUrl, map);
            pageInfo = (LOJQuestionPageInfo) lojParser.parseJson(response, LOJQuestionPageInfo.class);
            final List<Integer> temp = getQuestionIds(pageInfo);
            handleDetail(temp);
        }
    }

    private List<Integer> getQuestionIds(LOJQuestionPageInfo pageInfo) {
        List<Integer> ids = new ArrayList<>();
        if (pageInfo != null) {
            List<LOJQuetionItem> items = pageInfo.getResult();
            if (CollectionUtils.isNotEmpty(items)) {
                ids = items.stream().filter(item -> item.getMeta() != null).map(item -> item.getMeta().getId()).collect(Collectors.toList());
            }
        }
        return ids;
    }

    private void handleDetail(List<Integer> ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("judgeInfo", true);
        map.put("samples", true);
        map.put("tagsOfLocale", "zh_CN");
        map.put("statistics", true);
        map.put("localizedContentsOfLocale", "zh_CN");

        List<OJQuestionData> datas = new ArrayList<>();
        List<TagData> tagDatas = new ArrayList<>();
        List<String> tagNames = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            map.put("displayId", ids.get(i));
            HttpResponse response = lojDownloader.post(detailUrl, map);
            LOJQuestionDetail detail = (LOJQuestionDetail) lojParser.parseJson(response, LOJQuestionDetail.class);
            OJQuestionData data = new OJQuestionData();
            if (detail != null) {
                List<LOJTag> tags = detail.getTagsOfLocale();
                if (CollectionUtils.isNotEmpty(tags)) {
                    List<String> names = tags.stream().map(LOJTag::getName).collect(Collectors.toList());
                    data.setTags(names);
                    tagNames.addAll(names);
                }
            }
            data.setSections(new ArrayList<>());
            data.setSamples(new ArrayList<>());
            if (detail.getLocalizedContentsOfLocale() != null) {
                data.setTitle(detail.getLocalizedContentsOfLocale().getTitle());
                List<LOJSection> sections = detail.getLocalizedContentsOfLocale().getContentSections();
                for (LOJSection section : sections) {
                    data.getSections().add(new OJSectionData(section.getSectionTitle(), section.getText(),
                            section.getType(), section.getSampleId()));
                }
            }
            if (detail.getJudgeInfo() != null) {
                data.setTimeLimit(detail.getJudgeInfo().getTimeLimit());
                data.setMemoryLimit(detail.getJudgeInfo().getMemoryLimit());
            }
            if (detail.getSamples() != null) {
                for (LOJSample sample : detail.getSamples()) {
                    data.getSamples().add(new SampleData(sample.getInputData(), sample.getOutputData()));
                }
            }

            datas.add(data);
        }
        ojQuestionDal.insertMany(datas);
        tagDatas = tagNames.stream().distinct().collect(Collectors.toList()).stream().map(TagData::new).collect(Collectors.toList());
        tagMapper.batchCreate(tagDatas);
    }
}
