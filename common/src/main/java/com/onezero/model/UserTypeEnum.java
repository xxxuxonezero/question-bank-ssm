package com.onezero.model;

public enum UserTypeEnum {

    NORMAL_USER(0, "普通用户"),
    ADMIN(1, "管理员");

    private int id;
    private String desc;

    UserTypeEnum(int id, String desc) {
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
