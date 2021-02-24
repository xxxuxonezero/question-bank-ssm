package com.onezero.mongo;

import org.bson.Document;

public interface MongoMapper<T> {
    Document toDocument(T data);

    T toData(Document document);
}
