package com.onezero.bll.question.oj;

import com.onezero.mongo.data.OptionData;

import java.util.List;

public class Option {
    public static final String[] labels = {"A","B","C","D","E","F","G","H","I","J","K"};

    private String label;
    private String content;

    public Option() {
    }

    public Option(OptionData data) {
        if (data != null) {
            this.setContent(data.getContent());
            this.setLabel(data.getLabel());
        }
    }

    public OptionData toData() {
        OptionData data = new OptionData();
        data.setLabel(this.getLabel());
        data.setContent(this.getContent());
        return data;
    }

    public Option(String label, String content) {
        this.label = label;
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
