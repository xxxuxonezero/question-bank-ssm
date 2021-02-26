package com.onezero.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.onezero.datastructure.Page;
import com.onezero.mongo.data.QuestionData;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Repository
public class QuestionDal extends AbstractMongoDal<QuestionData> {
    private static final String COLLECTION_NAME = "question";

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public MongoHelper getMongoHelper() {
        return MongoHelperFactory.createMongoHelper(COLLECTION_NAME);
    }

    public QuestionData insert(QuestionData data) {
        return insert(data, questionMapper);
    }

    public void insertMany(List<QuestionData> datas) {
        insertMany(datas, questionMapper);
    }

    public void delete(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        delete(filter);
    }

    public Page<QuestionData> find(List<String> ids, String keyword, Integer type, int page, int pageSize) {
        Page<QuestionData> questionDataPage = new Page<>();
        Document filters = new Document();
        if (StringUtils.isNotEmpty(keyword)) {
            filters.append("content", new Document("$regex", keyword));
        }
        if (type != null) {
            filters.append("type", new Document("$eq", type));
        }
        if (CollectionUtils.isNotEmpty(ids)) {
            List<ObjectId> objectIds = ids.stream().map(ObjectId::new).collect(Collectors.toList());
            filters.append("_id", new Document("$in", objectIds));
        }
        Page<QuestionData> pageData = findByPage(filters, questionMapper, page, pageSize);
        return pageData;
    }
}
