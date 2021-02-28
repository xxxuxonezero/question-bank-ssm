package com.onezero.bll.question.oj;

import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.mongo.OJQuestionDal;
import com.onezero.mongo.data.OJQuestionData;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OJQuestionManager {
    private static final Logger logger = LoggerFactory.getLogger(OJQuestionManager.class);
    @Autowired
    private OJQuestionDal ojQuestionDal;

    public NoneDataResult create(OJQuestion ojQuestion) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (ojQuestion != null) {
                ojQuestionDal.insert(ojQuestion.toData());
            }
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public GenericResult<Page<OJQuestion>> search(String name, String tag, int page, int pageSize){
        GenericResult<Page<OJQuestion>> result = new GenericResult<>();
        try {
            Page<OJQuestionData> pageData = ojQuestionDal.findByPage(name, tag, page, pageSize);
            List<OJQuestionData> datas = pageData.getData();
            if (CollectionUtils.isNotEmpty(datas)) {
                result.setData(new Page<>(pageData.getTotalCount(),
                        datas.stream().map(OJQuestion::new).collect(Collectors.toList())));
            }
        } catch (Exception e) {
            logger.error("name: {}, tag: {} , error", name, tag, e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

    public GenericResult<List<OJQuestion>> getByIds(List<String> ids) {
        GenericResult<List<OJQuestion>> result = new GenericResult<>();
        try {
            result.setData(ojQuestionDal.getByIds(ids).stream().map(OJQuestion::new).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error("ids: {}, error", ids, e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }
}
