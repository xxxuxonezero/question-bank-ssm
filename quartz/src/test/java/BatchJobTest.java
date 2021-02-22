import com.onezero.bll.job.BatchJob;
import com.onezero.bll.job.BatchJobManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

public class BatchJobTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    BatchJobManager batchJobManager;

    @Before
    public void before() {
        batchJobManager = ac.getBean(BatchJobManager.class);
    }

    @Test
    public void create() {
        BatchJob batchJob = new BatchJob();
        batchJob.setJobName("gwtg");
        batchJob.setGroupName("dev");
        batchJob.setJobClass("com.onezero.gg");
        batchJobManager.create(batchJob);
        System.out.println(batchJob.getId());
    }

    @Test
    public void update() {
        GenericResult<Page<BatchJob>> pageResutl =
                batchJobManager.search("dev", null, null, null, 1, 1);
        Page<BatchJob> data = pageResutl.getData();
        System.out.println(data.getTotalCount());
        BatchJob batchJob = data.getData().get(0);
        batchJob.setJobStatus(3);
//        batchJobManager.update(batchJob);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void delete() {
        batchJobManager.delete(Collections.singletonList(1));
    }
}
