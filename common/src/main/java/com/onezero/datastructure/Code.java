package com.onezero.datastructure;

public enum Code implements ICode {
    OK(0, "SUCCESS"),
    INVALID_PARAMS(0x10000000, "无效的参数"),

    DATABASE_SELECT_ERROR(0x20000000, "数据库查询失败"),
    DATABASE_DELETE_ERROR(0x20000001, "数据库删除失败"),
    DATABASE_UPDATE_ERROR(0x20000002, "数据更新失败"),
    DATABASE_INSERT_ERROR(0x20000003, "数据库插入失败"),

    NO_AUTH(0X30000000,"无权限");


    private String msg;
    private int code;

    Code(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
