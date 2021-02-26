package com.onezero.downloader;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDownloader implements IDownloader {
    private static List<Header> headers = new ArrayList<>();

    /**
     * 添加头信息
     */
    static {
        headers.add(new BasicHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headers.add(new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36"));
        headers.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br"));
        headers.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));
        headers.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9"));
        headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8"));
    }

    @Override
    public HttpClient createHttpClient() {
        /**
         * 设置超时时间
         */
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .build();
        HttpClient httpClient = HttpClientBuilder
                .create().setDefaultHeaders(headers)
                .setDefaultRequestConfig(config).build();
         return httpClient;
    }

    @Override
    public HttpResponse get(URI uri) {
        return null;
    }

    @Override
    public HttpResponse post(URI uri) {
        return null;
    }

    @Override
    public HttpResponse get(String url) {
        return null;
    }

    @Override
    public HttpResponse post(String url) {
        return null;
    }
}
