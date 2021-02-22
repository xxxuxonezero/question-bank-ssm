package com.onezero.bll.account;

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
	private Date createdTime;
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
		if(data != null) {
			this.setId(data.getId());
			this.setDisplayName(data.getDisplayName());
			this.setEmail(data.getEmail());
			this.setPassword(data.getPassword());
			this.setType(data.getType());
			this.setAvatar(data.getAvatar());
			this.setIntroduction(data.getIntroduction());
			this.setCreatedTime(data.getCreatedTime());
			this.setUpdatedTime(data.getUpdatedTime());
		}
	}


	public User() {
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


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword() {
		return this.password;
	}


	public void setType(Integer type) {
		this.type = type;
	}

	public void setType(UserTypeEnum userTypeEnum) {
		this.type = userTypeEnum.id();
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
