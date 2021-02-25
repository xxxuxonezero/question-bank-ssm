package com.onezero.bll.question.oj;

import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.mongo.QuestionDal;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionManager {
    private static Logger logger = LoggerFactory.getLogger(QuestionManager.class);
    @Autowired
    private QuestionDal questionDal;

    public NoneDataResult create(Question question) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (question != null) {
                questionDal.insert(question.toData());
            }
        } catch (Exception e) {
            logger.error("question: {}, error", question, e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public NoneDataResult batchCreate(List<Question> questions) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (CollectionUtils.isNotEmpty(questions)) {
                questionDal.insertMany(questions.stream().map(item -> item.toData()).collect(Collectors.toList()));
            }
        } catch (Exception e) {
            logger.error("questionSize: {}, error", questions.size(), e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public GenericResult<Page<Question>> search() {
        GenericResult<Page<Question>> result = new GenericResult<>();
        try {

        } catch (Exception e) {
            logger.error("search error", e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }
}
