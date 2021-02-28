package com.onezero.bll.question;

import com.onezero.dal.TagMapper;
import com.onezero.dal.data.TagData;
import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TagManager {
    private static final Logger logger = LoggerFactory.getLogger(Tag.class);
    @Autowired
    private TagMapper tagMapper;

    public NoneDataResult create(Tag tag) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (tag != null) {
                tagMapper.create(tag.toData());
            }
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public NoneDataResult update(Tag tag) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (tag != null) {
                tagMapper.update(tag.toData());
            }
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_UPDATE_ERROR);
        }
        return result;
    }

    public NoneDataResult delete(List<Integer> ids) {
        NoneDataResult result = new NoneDataResult();
        try {
            tagMapper.delete(ids);
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_DELETE_ERROR);
        }
        return result;
    }

    public GenericResult<Page<Tag>> search(Integer parentId, Integer userId, Integer page, Integer pageSize) {
        GenericResult<Page<Tag>> result = new GenericResult<>();
        try {
            List<List<?>> list = tagMapper.search(parentId, userId, page, pageSize);
            List<TagData> dataList = (List<TagData>) list.get(0);
            List<Tag> tagList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(dataList)) {
                tagList = dataList.stream().map(Tag::new).collect(Collectors.toList());
            }
            result.setData(new Page(list.get(1).get(0), tagList));
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

    public GenericResult<List<Tag>> getByIds(List<Integer> ids) {
        GenericResult<List<Tag>> result = new GenericResult<>();
        try {
            List<TagData> dataList = tagMapper.getByIds(ids);
            if (CollectionUtils.isNotEmpty(dataList)) {
                List<Tag> tags = dataList.stream().map(Tag::new).collect(Collectors.toList());
                result.setData(tags);
            }
        } catch (Exception e) {
            logger.error("ids:{}, error", ids, e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

}
