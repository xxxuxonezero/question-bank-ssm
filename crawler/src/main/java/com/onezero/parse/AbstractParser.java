package com.onezero.parse;

import com.google.gson.Gson;
import com.onezero.utils.JSONUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public abstract class AbstractParser implements IParser{
    @Override
    public Object parseHtml(String html) {
        return null;
    }

    @Override
    public Object parseJson(String json, Class clazz) {
        Object o = null;
        try {
            o = JSONUtils.toObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public Object parseJson(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    @Override
    public Object parseHtml(HttpResponse response) {
        try {
            return this.parseHtml(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Object parseJson(HttpResponse response, Class clazz) {
        try {
            return this.parseJson(EntityUtils.toString(response.getEntity()), clazz);
        } catch (Exception e) {

        }
        return null;
    }
}
