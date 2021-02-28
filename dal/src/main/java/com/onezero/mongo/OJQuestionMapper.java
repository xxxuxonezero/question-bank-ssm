package com.onezero.mongo;

import com.onezero.mongo.data.OJQuestionData;
import com.onezero.mongo.data.OJSectionData;
import com.onezero.mongo.data.SampleData;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OJQuestionMapper extends MongoBaseMapper<OJQuestionData> {
    @Override
    public Document toDocument(OJQuestionData data) {
        Document doc = super.toDocument(data);
        doc.put("sections", datas2DocumentList(data.getSections(), OJSectionData.class));
        doc.put("samples", datas2DocumentList(data.getSamples(), SampleData.class));
        return doc;
    }

    @Override
    public OJQuestionData toData(Document document) {
        OJQuestionData data = new OJQuestionData();

        if (document != null) {
            data.setId(document.getObjectId("_id").toHexString());
            data.setMemoryLimit(document.getInteger("memory_limit"));
            data.setTimeLimit(document.getInteger("time_limit"));
            data.setTitle(document.getString("title"));
            data.setTags(document.getList("tags", String.class));
            data.setSamples(docs2SampleList(document.getList("samples", Document.class)));
            data.setSections(docs2SectionList(document.getList("sections", Document.class)));
        }
        return data;
    }

    private List<SampleData> docs2SampleList(List<Document> docs) {
        List<SampleData> samples = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(docs)) {
            for (Document doc : docs) {
                samples.add(new SampleData(doc.getString("input_data"), doc.getString("output_data")));
            }
        }
        return samples;
    }

    private List<OJSectionData> docs2SectionList(List<Document> docs) {
        List<OJSectionData> datas = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(docs)) {
            for (Document doc : docs) {
                datas.add(new OJSectionData(doc.getString("title"), doc.getString("content"), doc.getString("type"), doc.getInteger("sample_id")));
            }
        }
        return datas;
    }
}
