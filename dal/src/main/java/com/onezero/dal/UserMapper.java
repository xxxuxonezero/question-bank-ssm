package com.onezero.dal;

import com.onezero.dal.data.UserData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    void create(UserData data);

    void update(UserData data);

    void delete(List<Integer> ids);

    List<List<?>> search(@Param("email") String email,
                         @Param("password") String password,
                         @Param("type") Integer type,
                         @Param("page") Integer page,
                         @Param("pageSize") Integer pageSize);

    void resetPassword(@Param("id") Integer id,
                       @Param("password") String password);
}
