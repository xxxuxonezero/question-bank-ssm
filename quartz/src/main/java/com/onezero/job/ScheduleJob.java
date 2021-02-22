package com.onezero.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onezero.BaseObject;
import com.onezero.bll.job.BatchJob;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

public class ScheduleJob {

    public static final int WAITING = 0;
    public static final int RUNNING = 1;
    public static final int STOP = 2;

    private int id;
    private String jobName;
    private String groupName;
    private String jobCron;
    private String jobParams;
    private String jobClass;
    private int jobStatus;

    public ScheduleJob() {
    }

    public ScheduleJob(BatchJob batchJob) {
        if (batchJob != null) {
            this.id = batchJob.getId();
            this.jobClass = batchJob.getJobClass();
            this.jobCron = batchJob.getJobCron();
            this.jobParams = batchJob.getJobParams();
            this.jobName = batchJob.getJobName();
            this.jobStatus = batchJob.getJobStatus();
            this.groupName = batchJob.getGroupName();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getJobParams() {
        return jobParams;
    }

    public void setJobParams(String jobParams) {
        this.jobParams = jobParams;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

}
