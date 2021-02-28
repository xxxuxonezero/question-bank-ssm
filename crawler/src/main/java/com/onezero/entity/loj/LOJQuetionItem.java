package com.onezero.entity.loj;

import java.util.List;

public class LOJQuetionItem {
    private String title;
    private String resultLocale;
    private List<LOJTag> tags;
    private Meta meta;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResultLocale() {
        return resultLocale;
    }

    public void setResultLocale(String resultLocale) {
        this.resultLocale = resultLocale;
    }

    public List<LOJTag> getTags() {
        return tags;
    }

    public void setTags(List<LOJTag> tags) {
        this.tags = tags;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
