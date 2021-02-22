package com.onezero.datastructure;

public class GenericResult<T> extends AbstractResult<T>{

    private int code;
    private T data;
    private String msg;

    public GenericResult() {
        code = ICode.OK;
    }

    public GenericResult(int code) {
        this.code = code;
    }

    public GenericResult(ICode code) {
        this(code.getCode());
        this.setMsg(code.getMsg());
    }

    public GenericResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public GenericResult(ICode code, T data) {
        this(code.getCode(), data);
        this.setMsg(code.getMsg());
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(ICode code) {
        this.setCode(code.getCode());
        this.setMsg(code.getMsg());
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return null;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
