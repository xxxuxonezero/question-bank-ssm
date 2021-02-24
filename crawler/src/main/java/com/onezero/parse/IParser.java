package com.onezero.parse;

public interface IParser<T> {
    T parseHtml(String html);

    T parseJson(String json);
}
