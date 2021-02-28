package com.onezero.mongo.data;

import java.util.List;

public class OJQuestionData {
    private String id;
    private String title;
    private Integer memoryLimit;
    private Integer timeLimit;
    private List<OJSectionData> sections;
    private List<String> tags;
    private List<SampleData> samples;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public List<OJSectionData> getSections() {
        return sections;
    }

    public void setSections(List<OJSectionData> sections) {
        this.sections = sections;
    }

    public List<SampleData> getSamples() {
        return samples;
    }

    public void setSamples(List<SampleData> samples) {
        this.samples = samples;
    }
}
