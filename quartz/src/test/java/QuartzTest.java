import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
    @Test
    public void cronScheduler() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail detail = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "group1").build();
        Trigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()
                )
                .build();

        scheduler.scheduleJob(detail, trigger);
    }

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail detail = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "group2").build();
        JobDetail detail1 = JobBuilder.newJob(MyJob.class).withIdentity("myJob2", "group2").usingJobData("11", "11").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("group2")
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ? *")
                )
                .build();

        scheduler.scheduleJob(detail, trigger);
    }
}
