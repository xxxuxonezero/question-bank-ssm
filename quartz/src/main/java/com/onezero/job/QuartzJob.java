package com.onezero.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class QuartzJob implements InterruptableJob {
    private static final Logger logger = LoggerFactory.getLogger(QuartzJob.class);
    private AbstractJob currentJob;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap map = jobDetail.getJobDataMap();
        try {
            String jobName = (String) map.get("jobName");
            String jobClass = (String) map.get("jobClass");
            Class<?> clazz = Class.forName(jobClass);
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            Object o = constructor.newInstance(jobName);
            currentJob = (AbstractJob) o;
            currentJob.execute(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        logger.info("interrupt quartz.InterruptableJob");

        if (currentJob != null) {
            currentJob.stop();
        }
    }

}
