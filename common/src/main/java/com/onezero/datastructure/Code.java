package com.onezero.datastructure;

public enum Code implements ICode {
    OK(0, "SUCCESS"),
//    参数相关
    INVALID_PARAMS(0x10000000, "无效的参数"),
    INVALID_IMAGE(0x10000001, "无效的图片"),
    PUBLISH_TIME_CANNOT_BEFORE_CURRENT(0x10000002, "发布时间不能早于当前时间"),

//    数据库相关
    DATABASE_SELECT_ERROR(0x20000000, "数据库查询失败"),
    DATABASE_DELETE_ERROR(0x20000001, "数据库删除失败"),
    DATABASE_UPDATE_ERROR(0x20000002, "数据更新失败"),
    DATABASE_INSERT_ERROR(0x20000003, "数据库插入失败"),

//    用户相关
    NO_AUTH(0X30000000,"无权限"),
    EMAIL_OR_PASSWORD_ERROR(0X30000001, "用户名或密码输入错误");



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
