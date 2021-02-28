package com.onezero.bll.question.oj;

import com.onezero.mongo.data.OJSectionData;

public class OJSection {
    private String title;
    private String content;
    private String type;
    private Integer sampleId;

    public OJSection(OJSectionData data) {
        if (data != null) {
            this.title = data.getTitle();
            this.content = data.getContent();
            this.type = data.getType();
            this.sampleId = data.getSampleId();
        }
    }

    public OJSectionData toData() {
        OJSectionData data = new OJSectionData();
        data.setTitle(this.title);
        data.setContent(this.content);
        data.setType(this.type);
        data.setSampleId(this.sampleId);
        return data;
    }

    public OJSection() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }
}
