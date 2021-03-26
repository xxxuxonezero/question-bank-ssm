package com.onezero.cache;

import java.util.Date;

public interface ICache {
    void set(String key, Object value);

    <T> T get(String key, Class<T> clazz);

    void expire(String key, long time);

    void expireAt(String key, Date date);

    long expireTime(String key);

    void delete(String key);
}
