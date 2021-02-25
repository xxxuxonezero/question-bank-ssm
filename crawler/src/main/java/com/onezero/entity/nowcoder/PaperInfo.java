package com.onezero.entity.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class PaperInfo {
    private Integer pageNum;
    private List<String> questions;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void add(String url) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(url);
    }
}
