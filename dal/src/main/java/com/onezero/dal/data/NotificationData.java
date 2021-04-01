package com.onezero.dal.data;

import com.onezero.BaseObject;
import java.util.Date;

public class NotificationData extends BaseObject {
	private String title;
	private String content;
	private Integer userId;
	private Integer type;
	private String targetUser;
	private Date publishTime;
	private Date createdTime;
	private Date updatedTime;


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTitle() {
		return this.title;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getContent() {
		return this.content;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getUserId() {
		return this.userId;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getType() {
		return this.type;
	}


	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}


	public String getTargetUser() {
		return this.targetUser;
	}


	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}


	public Date getPublishTime() {
		return this.publishTime;
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
