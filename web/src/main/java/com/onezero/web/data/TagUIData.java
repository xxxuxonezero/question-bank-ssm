package com.onezero.web.data;

import com.onezero.BaseObject;
import com.onezero.bll.account.User;
import com.onezero.bll.question.Tag;

import java.util.Date;

public class TagUIData extends BaseObject {
    private Integer parentId;
    private String parentName;
    private String name;
    private Integer userId;
    private Date createdTime;
    private Date updatedTime;
    private String userName;

    public TagUIData(Tag tag, User user) {
        if (tag != null) {
            this.setId(tag.getId());
            this.setParentId(tag.getParentId());
            this.setParentName(tag.getParentName());
            this.setName(tag.getName());
            this.setUserId(tag.getUserId());
            this.setCreatedTime(tag.getCreatedTime());
            this.setUpdatedTime(tag.getUpdatedTime());
        }
        if (user != null) {
            this.setUserName(user.getDisplayName());
        }
    }

    public TagUIData() {
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
