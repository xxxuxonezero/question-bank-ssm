package com.onezero.mongo.data;

public class OptionData {
    private String label;
    private String content;

    public OptionData() {
    }

    public OptionData(String label, String content) {
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
