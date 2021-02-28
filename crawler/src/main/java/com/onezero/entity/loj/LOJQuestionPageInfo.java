package com.onezero.entity.loj;

import java.util.List;

public class LOJQuestionPageInfo {
    private int count;
    private List<LOJQuetionItem> result;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<LOJQuetionItem> getResult() {
        return result;
    }

    public void setResult(List<LOJQuetionItem> result) {
        this.result = result;
    }
}
