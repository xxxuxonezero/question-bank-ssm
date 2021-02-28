package com.onezero.framework;

import com.onezero.datastructure.NoneDataResult;

import java.util.List;

public abstract class AbstractController<T> implements IController<T>{
    @Override
    public NoneDataResult create(T t) {
        return null;
    }

    @Override
    public NoneDataResult update(T t) {
        return null;
    }

    @Override
    public NoneDataResult delete(List<Integer> ids) {
        return null;
    }
}
