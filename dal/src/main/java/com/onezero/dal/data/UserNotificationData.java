package com.onezero.dal.data;

import com.onezero.BaseObject;
import java.util.Date;
public class UserNotificationData extends BaseObject {
	private Integer userId;
	private Integer notificationId;
	private Integer status;
	private Date createdTime;
	private Date updatedTime;


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getUserId() {
		return this.userId;
	}


	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}


	public Integer getNotificationId() {
		return this.notificationId;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getStatus() {
		return this.status;
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
