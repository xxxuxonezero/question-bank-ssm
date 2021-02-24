package com.onezero.mongo;

import org.bson.Document;

public class MongoDocument extends Document {
    public MongoDocument() {
    }

    public MongoDocument(Document document) {
        super(document);
    }

    public Object put(String key, Object value) {
        return value == null ? null : super.put(key, value);
    }
}
