package com.onezero.web.data;

import com.onezero.bll.question.oj.OJQuestion;
import com.onezero.bll.question.oj.OJSection;
import com.onezero.bll.question.oj.Sample;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OJQuestionUIData {
    private String id;
    private String title;
    private Integer memoryLimit;
    private Integer timeLimit;
    private List<OJSection> sections;
    private List<String> tags;
    private List<Sample> samples;
    private int submissionCount;
    private int acceptedCount;

    public OJQuestionUIData() {
    }

    public OJQuestionUIData(OJQuestion data) {
        if (data != null) {
            this.id = data.getId();
            this.title = data.getTitle();
            this.memoryLimit = data.getMemoryLimit();
            this.timeLimit = data.getTimeLimit();
            this.tags = data.getTags();
            this.sections = data.getSections();
            this.samples = data.getSamples();
        }
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

    public int getSubmissionCount() {
        return submissionCount;
    }

    public void setSubmissionCount(int submissionCount) {
        this.submissionCount = submissionCount;
    }

    public int getAcceptedCount() {
        return acceptedCount;
    }

    public void setAcceptedCount(int acceptedCount) {
        this.acceptedCount = acceptedCount;
    }
}
