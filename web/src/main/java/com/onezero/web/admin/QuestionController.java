package com.onezero.web.admin;

import com.onezero.bll.question.Question;
import com.onezero.bll.question.QuestionManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.framework.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete")
    public NoneDataResult delete(@RequestParam("ids") List<String> ids) {
        return questionManager.delete(ids);
    }

    @PostMapping("/update")
    public NoneDataResult update(@RequestBody Question question) {
        return questionManager.update(question);
    }

    @PostMapping("/create")
    public NoneDataResult create(@RequestBody Question question) {
        return questionManager.create(question);
    }
}
