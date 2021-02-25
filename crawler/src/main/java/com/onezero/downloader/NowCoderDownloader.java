package com.onezero.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class NowCoderDownloader extends AbstractDownloader {
    @Override
    public HttpResponse get(URI uri) {
        HttpResponse response = null;
        try {
            HttpGet get = new HttpGet(uri);
            response = createHttpClient().execute(get);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public HttpResponse get(String url) {
        HttpResponse response = null;
        if (StringUtils.isNotEmpty(url)) {
            try {
                URI uri = new URIBuilder(url).build();
                response = get(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
