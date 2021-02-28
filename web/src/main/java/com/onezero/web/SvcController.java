package com.onezero.web;

import com.onezero.bll.question.oj.OJQuestion;
import com.onezero.bll.question.oj.OJQuestionManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.Page;
import com.onezero.web.data.OJQuestionInfoUIData;
import com.onezero.web.data.OJQuestionUIData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Svc")
public class SvcController {
    @Autowired
    private OJQuestionManager ojQuestionManager;

    @GetMapping("/oj/getList")
    public GenericResult<Page<List<OJQuestionInfoUIData>>> ojGetList(@RequestParam(value = "title", required = false) String title,
                                                                     @RequestParam(value = "tag", required = false) String tag,
                                                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        GenericResult<Page<List<OJQuestionInfoUIData>>> result = new GenericResult<>();
        GenericResult<Page<OJQuestion>> pageResult = ojQuestionManager.search(title, tag, page, pageSize);
        if (pageResult.isNotValid()) {
            result.setCode(result.getCode());
            return result;
        }
        List<OJQuestion> datas = pageResult.getData().getData();
        if (CollectionUtils.isNotEmpty(datas)) {
            List<OJQuestionInfoUIData> uiDataList = datas.stream().map(OJQuestionInfoUIData::new).collect(Collectors.toList());
            result.setData(new Page<>((Integer)pageResult.getData().getTotalCount(), uiDataList));
        }
        return result;
    }

    @GetMapping("/oj/detail")
    public GenericResult<OJQuestionUIData> getOJDetail(@RequestParam("id") String id) {
        GenericResult<OJQuestionUIData> result = new GenericResult<>();
        GenericResult<List<OJQuestion>> questionsResult = ojQuestionManager.getByIds(Collections.singletonList(id));
        if (questionsResult.isNotValid()) {
            result.setCode(questionsResult.getCode());
            return result;
        }
        OJQuestion question = questionsResult.getData().get(0);
        result.setData(new OJQuestionUIData(question));
        return result;
    }

}
