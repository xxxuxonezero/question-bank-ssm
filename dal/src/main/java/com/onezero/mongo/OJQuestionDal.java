package com.onezero.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.onezero.datastructure.Page;
import com.onezero.mongo.data.OJQuestionData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OJQuestionDal extends AbstractMongoDal{
    private static final String COLLECTION_NAME = "oj_question";
    @Autowired
    private OJQuestionMapper ojQuestionMapper;
    @Override
    public MongoHelper getMongoHelper() {
        return MongoHelperFactory.createMongoHelper(COLLECTION_NAME);
    }

    public void insert(OJQuestionData data) {
        insert(data, ojQuestionMapper);
    }

    public void insertMany(List<OJQuestionData> dataList) {
        insertMany(dataList, ojQuestionMapper);
    }

    public Page<OJQuestionData> findByPage(String title, String tag, int page, int pageSize) {
        Document document = new Document();
        if (StringUtils.isNotEmpty(title)) {
            document.append("title", new Document("$regex", title));
        }
        if (StringUtils.isNotEmpty(tag)) {
            document.append("tags", new Document("$eq", tag));
        }
        return findByPage(document, ojQuestionMapper, page, pageSize);
    }

    public List<OJQuestionData> getByIds(List<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            List<ObjectId> objectIds = ids.stream().map(ObjectId::new).collect(Collectors.toList());
            Bson filter = Filters.in("_id", objectIds);
            return find(filter, ojQuestionMapper);
        }
        return new ArrayList<>();
    }
}
