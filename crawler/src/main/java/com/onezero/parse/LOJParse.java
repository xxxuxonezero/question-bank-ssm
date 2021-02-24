package com.onezero.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onezero.entity.loj.LOJJudgeInfo;
import com.onezero.entity.loj.LOJQuestionDetail;
import com.onezero.utils.JSONUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LOJParse {
    public static void main(String[] args) throws URISyntaxException, IOException {
//        String url = "https://api.loj.ac.cn/api/problem/queryProblemSet";
        String url = "https://api.loj.ac.cn/api/problem/getProblem";
        URI uri = new URIBuilder(url).build();
        List<Header> headerList= new ArrayList<>();
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headerList.add(new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br"));
        headerList.add(new BasicHeader(HttpHeaders.CONNECTION,
                "keep-alive"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,
                "zh-CN,zh;q=0.9"));
        headerList.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8"));
        List<NameValuePair> params = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
//        map.put("skipCount", 50);
//        map.put("takeCount", 50);
//        map.put("locale", "zh_CN");
        map.put("displayId", 523);
        map.put("judgeInfo", true);
        map.put("samples", true);
        map.put("tagsOfLocale", "zh_CN");
        map.put("statistics", true);
        map.put("localizedContentsOfLocale", "zh_CN");
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(map);
        System.out.println(s);
        HttpPost httpPost = new HttpPost(uri);
        StringEntity se = new StringEntity(s);
        se.setContentType("json");
        httpPost.setEntity(se);
        HttpClient httpClient = HttpClientBuilder.create().setDefaultHeaders(headerList).build();

        HttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().toString());
        String obj = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(obj);
        LOJQuestionDetail detail = (LOJQuestionDetail) JSONUtils.toObject(obj, LOJQuestionDetail.class);
        System.out.println(detail);
    }

}
