package com.onezero.bll.job;

import com.onezero.BaseObject;
import com.onezero.dal.data.BatchJobData;

import java.util.Date;
public class BatchJob extends BaseObject {
	private String groupName;
	private String jobName;
	private String jobClass;
	private String jobCron;
	private String jobParams;
	private Integer jobStatus;
	private Date createdTime;
	private Date updatedTime;


	public BatchJobData toData() {
		BatchJobData data = new BatchJobData();
		data.setId(this.getId());
		data.setGroupName(this.getGroupName());
		data.setJobName(this.getJobName());
		data.setJobClass(this.getJobClass());
		data.setJobCron(this.getJobCron());
		data.setJobParams(this.getJobParams());
		data.setJobStatus(this.getJobStatus());
		data.setCreatedTime(this.getCreatedTime());
		data.setUpdatedTime(this.getUpdatedTime());
		return data;
	}


	public BatchJob(BatchJobData data) {
		if(data != null) {
			this.setId(data.getId());
			this.setGroupName(data.getGroupName());
			this.setJobName(data.getJobName());
			this.setJobClass(data.getJobClass());
			this.setJobCron(data.getJobCron());
			this.setJobParams(data.getJobParams());
			this.setJobStatus(data.getJobStatus());
			this.setCreatedTime(data.getCreatedTime());
			this.setUpdatedTime(data.getUpdatedTime());
		}
	}


	public BatchJob() {
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getGroupName() {
		return this.groupName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobName() {
		return this.jobName;
	}


	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}


	public String getJobClass() {
		return this.jobClass;
	}


	public void setJobCron(String jobCron) {
		this.jobCron = jobCron;
	}


	public String getJobCron() {
		return this.jobCron;
	}


	public void setJobParams(String jobParams) {
		this.jobParams = jobParams;
	}


	public String getJobParams() {
		return this.jobParams;
	}


	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}


	public Integer getJobStatus() {
		return this.jobStatus;
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
