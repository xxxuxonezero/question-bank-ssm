package com.onezero.dal;

import com.onezero.dal.data.UserNotificationData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserNotificationMapper {
    void batchCreate(List<UserNotificationData> datas);

    void batchUpdate(List<UserNotificationData> datas);

    void delete(List<Integer> notificationIds);

    List<List<?>> search(@Param("userId") int userId,
                         @Param("page") Integer page,
                         @Param("pageSize") Integer pageSize);

}