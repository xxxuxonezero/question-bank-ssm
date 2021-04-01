package com.onezero.model;

public enum NotificationTypeEnum {
    UPDATE(1, "升级更新通知"),
    COMPETITION(2, "比赛开始通知"),
    COMMON(3, "通知")
    ;

    private int id;
    private String desc;

    NotificationTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int id() {
        return id;
    }

    public String desc() {
        return desc;
    }

}
