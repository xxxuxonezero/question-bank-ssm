package com.onezero.mongo;

import com.onezero.mongo.data.OptionData;
import com.onezero.mongo.data.QuestionData;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionMapper extends MongoBaseMapper<QuestionData> {
    @Override
    public Document toDocument(QuestionData data) {
        Document doc = super.toDocument(data);
        if (doc != null) {
            doc.put("options", datas2DocumentList(data.getOptions()));
        }
        return doc;
    }

    @Override
    public QuestionData toData(Document document) {
        QuestionData data = new QuestionData();
        data.setId(document.getObjectId("_id").toHexString());
        data.setAnswer(document.getString("answer"));
        data.setAnalysis(document.getString("analysis"));
        data.setAuthorId(document.getInteger("author_id"));
        data.setContent(document.getString("content"));
        data.setType(document.getInteger("type"));
        data.setDifficulty(document.getDouble("difficulty"));
        data.setOptions(docs2Datas(document.getList("options", Document.class)));
        data.setCreatedTime(document.getDate("created_time"));
        data.setUpdatedTime(document.getDate("updated_time"));
        return data;
    }

    private List<Document> datas2DocumentList(List<OptionData> options) {
        List<Document> docs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(options)) {
            for (OptionData option : options) {
                Document doc = new MongoDocument();
                doc.put("label", option.getLabel());
                doc.put("content", option.getContent());
                docs.add(doc);
            }
        }
        return docs;
    }

    private List<OptionData> docs2Datas(List<Document> docs) {
        List<OptionData> options = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(docs)) {
            for (Document doc : docs) {
                OptionData option = new OptionData(doc.getString("label"), doc.getString("content"));
                options.add(option);
            }
        }
        return options;
    }

}
