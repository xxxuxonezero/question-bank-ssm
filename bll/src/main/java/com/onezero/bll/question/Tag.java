package com.onezero.bll.question;

import com.onezero.BaseObject;
import com.onezero.dal.data.TagData;

import java.util.Date;
public class Tag extends BaseObject {
	private Integer parentId;
	private String parentName;
	private String name;
	private Integer userId;
	private Date createdTime;
	private Date updatedTime;


	public TagData toData() {
		TagData data = new TagData();
		data.setId(this.getId());
		data.setParentId(this.getParentId() == null ? 0 : this.getParentId());
		data.setParentName(this.getParentName());
		data.setName(this.getName());
		data.setUserId(this.getUserId() == null ? 0 : this.getUserId());
		data.setCreatedTime(this.getCreatedTime());
		data.setUpdatedTime(this.getUpdatedTime());
		return data;
	}


	public Tag(TagData data) {
		if(data != null) {
			this.setId(data.getId());
			this.setParentId(data.getParentId() == null ? 0 : data.getParentId());
			this.setParentName(data.getParentName());
			this.setName(data.getName());
			this.setUserId(data.getUserId() == null ? 0 : data.getUserId());
			this.setCreatedTime(data.getCreatedTime());
			this.setUpdatedTime(data.getUpdatedTime());
		}
	}


	public Tag() {
	}

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
