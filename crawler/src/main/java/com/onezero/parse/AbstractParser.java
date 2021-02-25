package com.onezero.parse;

import com.google.gson.Gson;
import com.onezero.utils.JSONUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public abstract class AbstractParser<T> implements IParser<T>{
    @Override
    public T parseHtml(String html) {
        return null;
    }

    @Override
    public T parseJson(String json, Class<T> clazz) {
        T o = null;
        try {
            o = (T) JSONUtils.toObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public T parseJson(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    @Override
    public T parseHtml(HttpResponse response) {
        try {
            return this.parseHtml(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public T parseJson(HttpResponse response, Class<T> clazz) {
        try {
            return this.parseJson(EntityUtils.toString(response.getEntity()), clazz);
        } catch (Exception e) {

        }
        return null;
    }
}
