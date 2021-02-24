package com.onezero.entity.loj;

import java.util.List;

public class LOJContent {
    private List<LOJSection> contentSections;
    private String title;

    public List<LOJSection> getContentSections() {
        return contentSections;
    }

    public void setContentSections(List<LOJSection> contentSections) {
        this.contentSections = contentSections;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
