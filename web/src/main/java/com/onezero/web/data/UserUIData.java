package com.onezero.web.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onezero.BaseObject;
import com.onezero.bll.account.User;

import java.util.Date;

public class UserUIData extends BaseObject {
    private String displayName;
    private String email;
    private Integer type;
    private String avatar;
    private String introduction;
    private String typeDesc;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    private Date updatedTime;

    public UserUIData(User data) {
        if(data != null) {
            this.setId(data.getId());
            this.setDisplayName(data.getDisplayName());
            this.setEmail(data.getEmail());
            this.setType(data.getType());
            this.setTypeDesc(data.getTypeDesc());
            this.setAvatar(data.getAvatar());
            this.setIntroduction(data.getIntroduction());
            this.setCreatedTime(data.getCreatedTime());
            this.setUpdatedTime(data.getUpdatedTime());
        }
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public String getDisplayName() {
        return this.displayName;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return this.email;
    }


    public void setType(Integer type) {
        this.type = type;
    }


    public Integer getType() {
        return this.type;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getAvatar() {
        return this.avatar;
    }


    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    public String getIntroduction() {
        return this.introduction;
    }


    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Date getCreatedTime() {
        return this.createdTime;
    }


    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }


    public Date getUpdatedTime() {
        return this.updatedTime;
    }
}
