package com.onezero.mongo;

import com.mongodb.client.model.Filters;
import com.onezero.mongo.data.QuestionData;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
}
