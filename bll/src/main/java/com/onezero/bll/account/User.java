package com.onezero.bll.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onezero.BaseObject;
import com.onezero.dal.data.UserData;
import com.onezero.model.UserTypeEnum;

import java.util.Date;

public class User extends BaseObject {
	private String displayName;
	private String email;
	private String password;
	private Integer type;
	private String avatar;
	private String introduction;
	private String typeDesc;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedTime;

	public UserData toData() {
		UserData data = new UserData();
		data.setId(this.getId());
		data.setDisplayName(this.getDisplayName());
		data.setEmail(this.getEmail());
		data.setPassword(this.getPassword());
		data.setType(this.getType());
		data.setAvatar(this.getAvatar());
		data.setIntroduction(this.getIntroduction());
		data.setCreatedTime(this.getCreatedTime());
		data.setUpdatedTime(this.getUpdatedTime());
		return data;
	}


	public User(UserData data) {
		if (data != null) {
			this.setId(data.getId());
			this.setDisplayName(data.getDisplayName());
			this.setEmail(data.getEmail());
			this.setPassword(data.getPassword());
			this.setType(data.getType());
			this.setAvatar(data.getAvatar());
			this.setIntroduction(data.getIntroduction());
			this.setTypeDesc(UserTypeEnum.getTypeDesc(data.getType()));
			this.setCreatedTime(data.getCreatedTime());
			this.setUpdatedTime(data.getUpdatedTime());
		}
	}

	public User() {
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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

}