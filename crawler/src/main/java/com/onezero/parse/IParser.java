package com.onezero.parse;

import org.apache.http.HttpResponse;

public interface IParser<T> {
    T parseHtml(String html);

    T parseJson(String json, Class<T> clazz);

    T parseHtml(HttpResponse response);

    T parseJson(HttpResponse response, Class<T> clazz);
}
