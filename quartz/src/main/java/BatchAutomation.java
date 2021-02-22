import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchAutomation implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(BatchAutomation.class);

    public BatchAutomation(String groupName) {

    }

    public void run() {
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity()
    }

    private Scheduler createScheduler() throws SchedulerException {
        return new StdSchedulerFactory().getScheduler();
    }
}
