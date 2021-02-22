package com.onezero.bll.job;

import com.onezero.dal.BatchJobMapper;
import com.onezero.dal.data.BatchJobData;
import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BatchJobManager {
    private static final Logger logger = LoggerFactory.getLogger(BatchJob.class);
    @Autowired
    private BatchJobMapper batchJobMapper;

    public NoneDataResult create(BatchJob batchJob) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (batchJob == null) {
                return result;
            }
            batchJobMapper.create(batchJob.toData());
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public NoneDataResult update(BatchJob batchJob) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (batchJob == null) {
                return result;
            }
            batchJobMapper.update(batchJob.toData());
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_UPDATE_ERROR);
        }
        return result;
    }

    public NoneDataResult delete(List<Integer> ids) {
        NoneDataResult result = new NoneDataResult();
        try {
            batchJobMapper.delete(ids);
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_DELETE_ERROR);
        }
        return result;
    }

    public GenericResult<Page<BatchJob>> search(String groupName, Integer status, String jobName, List<Integer> ids,
                                 Integer page, Integer pageSize) {
        GenericResult<Page<BatchJob>> result = new GenericResult<>();
        try {
            List<List<?>> jobPage = batchJobMapper.search(groupName, status, jobName, ids, page, pageSize);
            result.setData(new Page(jobPage.get(1).get(0), jobPage.get(0)));
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

    public GenericResult<Page<BatchJob>> getByStatus(Integer status) {
        GenericResult<Page<BatchJob>> result = new GenericResult<>();
        try {
            List<List<?>> jobPage = batchJobMapper.search(null, status, null, null, 1, Integer.MAX_VALUE);
            Page<BatchJobData> pageData = new Page<>(jobPage.get(1).get(0), jobPage.get(0));
            List<BatchJobData> list = pageData.getData();
            List<BatchJob> batchJobs = list.stream().map(BatchJob::new).collect(Collectors.toList());
            result.setData(new Page<>(pageData.getTotalCount(), batchJobs));
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }
}
