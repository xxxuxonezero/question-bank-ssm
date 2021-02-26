package com.onezero.mongo;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.onezero.datastructure.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 由于系统中只用了一个mongo数据库，故直接在该类中写死
 * @param <T>
 */
public class MongoHelper<T> {
    private static MongoDatabase database = MongoClients.create().getDatabase("question-bank");
    private MongoCollection<Document> collection;

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void setCollection(String str) {
        if (this.getDatabase().getCollection(str) == null) {
            this.getDatabase().createCollection(str);
        }
        collection = this.getDatabase().getCollection(str);
    }

    public T insert(T data, MongoMapper<T> mapper) {
        if (data != null) {
            Document doc = mapper.toDocument(data);
            doc.put("created_time", new Date());
            doc.put("updated_time", new Date());
            this.getCollection().insertOne(doc);
            return mapper.toData(doc);
        }
        return null;
    }

    public void insertMany(List<T> datas, MongoMapper<T> mapper) {
        if (CollectionUtils.isNotEmpty(datas)) {
            List<Document> docs = new ArrayList<>();
            for (T data : datas) {
                Document doc = mapper.toDocument(data);
                doc.put("created_time", new Date());
                doc.put("updated_time", new Date());
                docs.add(doc);
            }
            this.getCollection().insertMany(docs);
        }
    }

    public List<T> find(Bson filter, MongoMapper<T> mapper){
        List<T> list = new ArrayList<>();
        FindIterable<Document> docsIterable = this.getCollection().find(filter);
        if (docsIterable != null) {
            MongoCursor<Document> iterator = docsIterable.iterator();
            while (iterator.hasNext()) {
                Document doc = iterator.next();
                list.add(mapper.toData(doc));
            }
        }
        return list;
    }

    public Page<T> findByPage(Bson filter, MongoMapper<T> mapper, int page, int pageSize){
        Page<T> res = new Page<>();
        FindIterable<Document> findIterable = this.getCollection().find(filter).skip((page - 1) * pageSize).limit(pageSize);
        long count = this.getCollection().countDocuments(filter);
        if (findIterable != null) {
            List<T> list = new ArrayList<>();
            MongoCursor<Document> iterator = findIterable.iterator();
            while (iterator.hasNext()) {
                Document doc = iterator.next();
                list.add(mapper.toData(doc));
            }
            res.setTotalCount((int) count);
            res.setData(list);
        }
        return res;
    }

    public void delete(Bson filter){
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(filter);
    }

    public void update(Bson filter,T data, MongoMapper<T> mapper) {
        Document doc = mapper.toDocument(data);
        doc.put("updated_time", new Date());
        Bson updateBson = new Document("$set", doc);
        this.getCollection().updateOne(filter, updateBson);
    }

    public T getFirst(Bson filter, MongoMapper<T> mapper) {
        Document doc = this.getCollection().find(filter).first();
        return mapper.toData(doc);
    }
}
