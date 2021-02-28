package com.onezero.web.admin;

import com.onezero.bll.account.UserManager;
import com.onezero.bll.job.BatchJob;
import com.onezero.bll.job.BatchJobManager;
import com.onezero.bll.question.Question;
import com.onezero.bll.question.QuestionManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/batchJob")
public class BatchJobController {
    @Autowired
    private BatchJobManager batchJobManager;
    @Autowired
    UserManager userManager;
    @Autowired
    QuestionManager questionManager;

    @GetMapping("/getList")
    public GenericResult<Page<BatchJob>> getList(@RequestParam(value = "jobName", required = false) String jobName,
                                                 @RequestParam(value = "groupName", required = false) String groupName,
                                                 @RequestParam(value = "status", required = false) Integer status,
                                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        GenericResult<Page<BatchJob>> result = new GenericResult<Page<BatchJob>>();
        result = batchJobManager.search(groupName, status, jobName, null, page, pageSize);
        return result;
    }

    @PostMapping("/create")
    public NoneDataResult create(@RequestBody BatchJob batchJob) {
        return batchJobManager.create(batchJob);
    }
    @PostMapping("/create1")
    public NoneDataResult create(@RequestBody Question question) {
        return questionManager.create(question);
    }

    @PostMapping("/update")
    public NoneDataResult update(@RequestBody BatchJob batchJob) {
        return batchJobManager.update(batchJob);
    }

    @PostMapping("/delete")
    public NoneDataResult delete(@RequestParam("ids") List<Integer> ids) {
        return batchJobManager.delete(ids);
    }
}
