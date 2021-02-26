package com.onezero.mongo;

import com.onezero.datastructure.Page;
import org.bson.conversions.Bson;

import java.util.List;

public abstract class AbstractMongoDal<T> implements MongoBaseDal<T>{

    public abstract MongoHelper<T> getMongoHelper();
    @Override
    public T insert(T data, MongoMapper<T> mapper) {
        return this.getMongoHelper().insert(data, mapper);
    }

    @Override
    public void insertMany(List<T> datas, MongoMapper<T> mapper) {
        this.getMongoHelper().insertMany(datas, mapper);
    }

    @Override
    public List<T> find(Bson bson, MongoMapper<T> mapper) {
        return this.getMongoHelper().find(bson, mapper);
    }

    public Page<T> findByPage(Bson bson, MongoMapper<T> mapper, int page, int pageSize) {
        return this.getMongoHelper().findByPage(bson, mapper, page, pageSize);
    }

    @Override
    public void delete(Bson bson) {
        this.getMongoHelper().delete(bson);
    }

    @Override
    public void update(Bson filter, T data, MongoMapper<T> mapper) {
        this.getMongoHelper().update(filter, data, mapper);
    }

    @Override
    public T getFirst(Bson bson, MongoMapper<T> mapper) {
        return this.getMongoHelper().getFirst(bson, mapper);
    }
}
