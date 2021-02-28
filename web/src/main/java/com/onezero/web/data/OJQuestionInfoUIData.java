package com.onezero.web.data;

import com.onezero.bll.question.oj.OJQuestion;

import java.util.List;

public class OJQuestionInfoUIData {
    private String id;
    private String title;
    private List<String> tags;
    private int submissionCount;
    private int acceptedCount;

    public OJQuestionInfoUIData(OJQuestion data) {
        if (data != null) {
            this.id = data.getId();
            this.title = data.getTitle();
            this.tags = data.getTags();
        }
    }

    public OJQuestionInfoUIData() {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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
