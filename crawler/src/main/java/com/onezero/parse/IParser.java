package com.onezero.parse;

public interface IParser<T> {
    T parse(String html);
}
