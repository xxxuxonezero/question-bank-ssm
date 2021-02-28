package com.onezero.downloader;

import com.onezero.utils.JSONUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LOJDownloader extends AbstractDownloader {

    public HttpResponse post(String url, Map<String, Object> formData) {
        String s = JSONUtils.toJson(formData);
        HttpPost post = new HttpPost(url);
        try {
            StringEntity se = new StringEntity(s);
            se.setContentType("json");
            post.setEntity(se);
            return createHttpClient().execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
