package com.onezero.entity.loj;

import com.onezero.dal.data.TagData;

public class LOJTag {
    private int id;
    private String name;

    public TagData toData() {
        TagData data = new TagData();
        data.setName(this.getName());
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
