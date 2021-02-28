package com.onezero.mongo.data;

public class OJSectionData {
    private String title;
    private String content;
    private String type;
    private Integer sampleId;

    public OJSectionData(String title, String content, String type, Integer sampleId) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.sampleId = sampleId;
    }

    public OJSectionData() {
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
