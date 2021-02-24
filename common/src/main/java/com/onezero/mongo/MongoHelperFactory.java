package com.onezero.mongo;

import java.util.concurrent.ConcurrentHashMap;

public class MongoHelperFactory {
    public static ConcurrentHashMap<String, MongoHelper> mongoMap = new ConcurrentHashMap<>();

    public static MongoHelper createMongoHelper(String collection) {
        if (!mongoMap.contains(collection)) {
            MongoHelper mongoHelper = new MongoHelper();
            mongoHelper.setCollection(collection);
            mongoMap.put(collection, mongoHelper);
        }
        return mongoMap.get(collection);
    }
}
