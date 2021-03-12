package com.onezero.web.data;

import com.onezero.BaseObject;

import java.util.Date;

public class Identity extends BaseObject {
    private Date loginTime;
    private long expireTime;

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
