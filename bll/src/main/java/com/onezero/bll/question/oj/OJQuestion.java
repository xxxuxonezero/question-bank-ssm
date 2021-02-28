package com.onezero.bll.question.oj;

import com.onezero.mongo.data.OJQuestionData;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OJQuestion {
    private String id;
    private String title;
    private Integer memoryLimit;
    private Integer timeLimit;
    private List<OJSection> sections;
    private List<String> tags;
    private List<Sample> samples;

    public OJQuestion() {
    }

    public OJQuestion(OJQuestionData data) {
        if (data != null) {
            this.id = data.getId();
            this.title = data.getTitle();
            this.memoryLimit = data.getMemoryLimit();
            this.timeLimit = data.getTimeLimit();
            this.tags = data.getTags();
            if (CollectionUtils.isNotEmpty(data.getSections())) {
                this.sections = data.getSections().stream().map(OJSection::new).collect(Collectors.toList());
            }
            if (CollectionUtils.isNotEmpty(data.getSamples())) {
                this.samples = data.getSamples().stream().map(Sample::new).collect(Collectors.toList());
            }
        }
    }

    public OJQuestionData toData() {
        OJQuestionData data = new OJQuestionData();
        data.setId(this.id);
        data.setTitle(this.title);
        data.setTags(this.tags);
        data.setMemoryLimit(this.memoryLimit);
        data.setTimeLimit(this.timeLimit);
        if (CollectionUtils.isNotEmpty(this.samples)) {
            data.setSamples(this.samples.stream().map(Sample::toData).collect(Collectors.toList()));
        }
        if (CollectionUtils.isNotEmpty(this.sections)) {
            data.setSections(this.sections.stream().map(OJSection::toData).collect(Collectors.toList()));
        }
        return data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<OJSection> getSections() {
        return sections;
    }

    public void setSections(List<OJSection> sections) {
        this.sections = sections;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }
}
