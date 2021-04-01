package com.onezero.dal;

import com.onezero.dal.data.NotificationData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationMapper {
    void create(NotificationData data);

    void update(NotificationData data);

    void delete(List<Integer> ids);

    List<List<?>> search(@Param("userId") int userId,
                         @Param("page") int page,
                         @Param("pageSize") int pageSize);

    NotificationData getById(int id);

}