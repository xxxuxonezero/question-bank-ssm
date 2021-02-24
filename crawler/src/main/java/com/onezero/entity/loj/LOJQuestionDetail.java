package com.onezero.entity.loj;


import java.util.List;

public class LOJQuestionDetail {
    private LOJContent localizedContentsOfLocale;
    private List<LOJSample> samples;
    private List<LOJTag> tagsOfLocale;
    private LOJJudgeInfo judgeInfo;

    public LOJContent getLocalizedContentsOfLocale() {
        return localizedContentsOfLocale;
    }

    public void setLocalizedContentsOfLocale(LOJContent localizedContentsOfLocale) {
        this.localizedContentsOfLocale = localizedContentsOfLocale;
    }

    public List<LOJSample> getSamples() {
        return samples;
    }

    public void setSamples(List<LOJSample> samples) {
        this.samples = samples;
    }

    public List<LOJTag> getTagsOfLocale() {
        return tagsOfLocale;
    }

    public void setTagsOfLocale(List<LOJTag> tagsOfLocale) {
        this.tagsOfLocale = tagsOfLocale;
    }

    public LOJJudgeInfo getJudgeInfo() {
        return judgeInfo;
    }

    public void setJudgeInfo(LOJJudgeInfo judgeInfo) {
        this.judgeInfo = judgeInfo;
    }
}
