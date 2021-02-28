package com.onezero.dal;

import com.onezero.dal.data.TagData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    void create(TagData data);

    void batchCreate(List<TagData> datas);

    void update(TagData data);

    void delete(List<Integer> ids);

    List<List<?>> search(@Param("parentId") Integer parentId,
                         @Param("userId") Integer userId,
                         @Param("page") Integer page,
                         @Param("pageSize") Integer pageSize);

    List<TagData> getByIds(List<Integer> ids);

}