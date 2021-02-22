package com.onezero.dal.data;

import com.onezero.BaseObject;
import java.util.Date;
public class UserData extends BaseObject {
	private String displayName;
	private String email;
	private String password;
	private Integer type;
	private String avatar;
	private String introduction;
	private Date createdTime;
	private Date updatedTime;


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
