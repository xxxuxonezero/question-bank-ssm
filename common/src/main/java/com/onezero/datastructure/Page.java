package com.onezero.datastructure;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private int totalCount;
    private List<T> data;

    public Page(int totalCount, List<T> data) {
        this.totalCount = totalCount;
        this.data = data == null ? new ArrayList<T>() : data;
    }

    public Page(Object totalCount, Object data) {
        this.totalCount = (Integer) totalCount;
        this.data = data == null ? new ArrayList<T>() : (List<T>) data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
