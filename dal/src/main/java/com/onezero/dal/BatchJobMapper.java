package com.onezero.dal;

import com.onezero.dal.data.BatchJobData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatchJobMapper {
    List<BatchJobData> getAll();

    void create(BatchJobData batchJob);

    void update(BatchJobData batchJob);

    void delete(List<Integer> ids);

    List<List<?>> search(@Param("groupName") String groupName,
                         @Param("jobStatus") Integer status,
                         @Param("jobName") String jobName,
                         @Param("ids") List<Integer> ids,
                         @Param("page") Integer page,
                         @Param("pageSize") Integer pageSize);
}
