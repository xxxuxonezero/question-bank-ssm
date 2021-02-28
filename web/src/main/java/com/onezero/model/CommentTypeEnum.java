package com.onezero.model;

public enum CommentTypeEnum {
    QUESTION_TYPE(0, "QUESTION"),
    ONLINE_JUDGE(1, "OJ"),
    FORUM_JUDGE(2, "FORUM"),
    ;
    private int id;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    CommentTypeEnum(int id, String desc) {


        this.id = id;
        this.desc = desc;
    }
}
