package com.onezero.dal.data;

import com.onezero.BaseObject;
import java.util.Date;
public class TagData extends BaseObject {
	private Integer parentId;
	private String parentName;
	private String name;
	private Integer userId;
	private Date createdTime;
	private Date updatedTime;


	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public Integer getParentId() {
		return this.parentId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return this.name;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getUserId() {
		return this.userId;
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
