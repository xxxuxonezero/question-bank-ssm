package com.onezero.bll.question.oj;

import com.onezero.mongo.data.OptionData;
import com.onezero.mongo.data.QuestionData;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String id;
    private String content;
    private List<Option> options;
    private List<Question> subQuestions;
    private String answer;
    private Integer type;
    private String typeDes;
    private Integer authorId;
    private Double difficulty;
    private String analysis;
    private Date createdTime;
    private Date updatedTime;

    public Question() {
    }

    public Question(QuestionData data) {
        if (data != null) {
            this.setId(this.getId());
            this.setContent(data.getContent());
            if (CollectionUtils.isNotEmpty(data.getOptions())) {
                this.setOptions(data.getOptions().stream().map(Option::new).collect(Collectors.toList()));
            }
            if (CollectionUtils.isNotEmpty(data.getSubQuestions())) {
                this.setSubQuestions(data.getSubQuestions().stream().map(Question::new).collect(Collectors.toList()));
            }
            this.setAnalysis(data.getAnalysis());
            this.setAnswer(data.getAnswer());
            this.setDifficulty(data.getDifficulty());
            this.setType(data.getType());
            this.setAuthorId(data.getAuthorId());
            this.setCreatedTime(data.getCreatedTime());
            this.setUpdatedTime(data.getUpdatedTime());
        }
    }

    public QuestionData toData() {
        QuestionData data = new QuestionData();
        data.setId(this.getId());
        data.setContent(this.getContent());
        if (CollectionUtils.isNotEmpty(this.getOptions())) {
            data.setOptions(this.getOptions().stream().map(item -> item.toData()).collect(Collectors.toList()));
        }
        if (CollectionUtils.isNotEmpty(this.getSubQuestions())) {
            data.setSubQuestions(this.getSubQuestions().stream().map(item -> item.toData()).collect(Collectors.toList()));
        }
        data.setAnalysis(this.getAnalysis());
        data.setAnswer(this.getAnswer());
        data.setDifficulty(this.getDifficulty());
        data.setType(this.getType());
        data.setAuthorId(this.getAuthorId());
        data.setCreatedTime(this.getCreatedTime());
        data.setUpdatedTime(this.getUpdatedTime());
        return data;
    }

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }

    public List<Question> getSubQuestions() {
        return subQuestions;
    }

    public void setSubQuestions(List<Question> subQuestions) {
        this.subQuestions = subQuestions;
    }

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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
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
