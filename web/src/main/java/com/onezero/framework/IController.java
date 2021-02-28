package com.onezero.framework;

import com.onezero.datastructure.NoneDataResult;

import java.util.List;

public interface IController<T> {
    NoneDataResult create(T t);

    NoneDataResult update(T t);

    NoneDataResult delete(List<Integer> ids);
}
