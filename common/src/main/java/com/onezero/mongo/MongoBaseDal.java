package com.onezero.mongo;

import org.bson.conversions.Bson;

import java.util.List;

public interface MongoBaseDal<T> {

    MongoHelper getMongoHelper();

    T insert(T data, MongoMapper<T> mapper);

    void insertMany(List<T> datas, MongoMapper<T> mapper);

    List<T> find(Bson bson, MongoMapper<T> mapper);

    void delete(Bson bson);

    void update(Bson filter, T data, MongoMapper<T> mapper);

    T getFirst(Bson bson, MongoMapper<T> mapper);
}
