package com.onezero.web.admin;

import com.onezero.bll.question.oj.Question;
import com.onezero.bll.question.oj.QuestionManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/question")
public class QuestionController {
    @Autowired
    private QuestionManager questionManager;

    @GetMapping("/getList")
    public GenericResult<Page<Question>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                 @RequestParam(value = "type", required = false) Integer type,
                                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return questionManager.search(keyword, type, page, pageSize);
    }
}
