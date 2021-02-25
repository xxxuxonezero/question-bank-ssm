package com.onezero.mongo.data;

import java.util.Date;
import java.util.List;

public class QuestionData {
    private String id;
    private String content;
    private List<OptionData> options;
    private List<QuestionData> subQuestions;
    private String answer;
    private Integer type;
    private Integer authorId;
    private Double difficulty;
    private String analysis;
    private Date createdTime;
    private Date updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<OptionData> getOptions() {
        return options;
    }

    public void setOptions(List<OptionData> options) {
        this.options = options;
    }

    public List<QuestionData> getSubQuestions() {
        return subQuestions;
    }

    public void setSubQuestions(List<QuestionData> subQuestions) {
        this.subQuestions = subQuestions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
