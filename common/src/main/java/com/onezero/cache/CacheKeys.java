package com.onezero.cache;

public enum CacheKeys {
    USER_BY_ID("USER_BY_ID_%d"),
    NORMAL_QUESTION_BY_ID("NORMAL_QUESTION_BY_ID_%s"),
    OJ_QUESTION_BY_ID("OJ_QUESTION_BY_ID_%s");

    private String id;

    CacheKeys(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
