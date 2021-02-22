package com.onezero.job;

import com.onezero.bll.job.BatchJob;
import com.onezero.bll.job.BatchJobManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InitQuartzJob {
    @Autowired
    private BatchJobManager batchJobManager;
    private static final int TIME = 20000;
    private static Scheduler scheduler;
    private static Map<Integer, Trigger> triggerMap = new HashMap<>();

    /**
     * 轮询batch_job，执行定时任务
     * @throws SchedulerException
     */
    @PostConstruct
    public void init() throws SchedulerException {
        while (true) {
            GenericResult<Page<BatchJob>> batchJobsResult = batchJobManager.getByStatus(ScheduleJob.RUNNING);
            if (batchJobsResult.isNotValid()) {
                return;
            }
            Page<BatchJob> page = batchJobsResult.getData();
            List<BatchJob> batchJobs = page.getData();
            if (CollectionUtils.isNotEmpty(batchJobs)) {
                scheduler = createScheduler();
                List<ScheduleJob> scheduleJobs =
                        batchJobs.stream().map(ScheduleJob::new).collect(Collectors.toList());
                scheduler.start();
                for (ScheduleJob job : scheduleJobs) {
                    addJob(job);
                }
            }
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void addJob(ScheduleJob job) throws SchedulerException {
        Trigger trigger = triggerMap.get(job.getId());
        if (trigger == null) {
            JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                    .usingJobData("jobClass", job.getJobClass())
                    .usingJobData("jobName", job.getJobName())
                    .usingJobData("groupName", job.getGroupName())
                    .usingJobData("jobId", job.getId())
                    .usingJobData("jobParams", job.getJobParams())
                    .withIdentity(String.valueOf(job.getId()), job.getGroupName())
                    .build();

            /**
             * 0--立即执行
             */
            if ("0".equals(job.getJobCron())) {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(jobDetail.getKey().toString())
                        .startNow()
                        .build();
            } else {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(jobDetail.getKey().toString())
                        .withSchedule(
                                CronScheduleBuilder.cronSchedule(job.getJobCron())
                        ).build();
            }

            triggerMap.put(job.getId(), trigger);
            scheduler.scheduleJob(jobDetail, trigger);
        }
    }

    public static void stopJob(ScheduleJob job) throws SchedulerException {
        scheduler.deleteJob(getJobKey(job));
    }

    private Scheduler createScheduler() throws SchedulerException {
        return new StdSchedulerFactory().getScheduler();
    }

    private static JobKey getJobKey(ScheduleJob job) {
        return new JobKey(String.valueOf(job.getId()), job.getGroupName());
    }
}
