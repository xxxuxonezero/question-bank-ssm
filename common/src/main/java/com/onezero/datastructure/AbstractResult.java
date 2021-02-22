package com.onezero.datastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Map;

public abstract class AbstractResult<T> {
    public abstract int getCode();

    public abstract T getData();

    public abstract String getMsg();

    @JsonIgnore
    public boolean isOK() {
        return getCode() == ICode.OK;
    }

    @JsonIgnore
    public boolean isNotOK () {
        return !isOK();
    }

    @JsonIgnore
    public boolean isValid () {
        return !(isNotOK() || isEmpty());
    }

    @JsonIgnore
    public boolean isEmpty () {
        T data = getData();
        return data == null ||
                (data instanceof List && ((List<?>) data).isEmpty()) ||
                (data instanceof Map && ((Map<?, ?>) data).isEmpty());
    }

    @JsonIgnore
    public boolean isNotValid() {
        return !isValid();
    }

    @JsonIgnore
    public boolean isNotEmpty() {
        return !isEmpty();
    }

}
