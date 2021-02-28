package com.onezero.web.admin;

import com.onezero.bll.account.User;
import com.onezero.bll.account.UserManager;
import com.onezero.bll.question.Tag;
import com.onezero.bll.question.TagManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.framework.AbstractController;
import com.onezero.web.data.TagUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/tag")
public class TagController extends AbstractController<Tag> {
    @Autowired
    private TagManager tagManager;
    @Autowired
    private UserManager userManager;

    @GetMapping("/getList")
    public GenericResult<Page<TagUIData>> getList(@RequestParam(value = "parentId", required = false) Integer parentId,
                                                  @RequestParam(value = "flag", required = false, defaultValue = "false") Boolean flag,
                                                  @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        GenericResult<Page<TagUIData>> result = new GenericResult<>();
        GenericResult<Page<Tag>> pageResult = tagManager.search(parentId, flag ? 0 : null, page, pageSize);
        if (pageResult.isNotValid()) {
            result.setCode(pageResult.getCode());
            return result;
        }
        Page<Tag> tagPage = pageResult.getData();
        List<Integer> userIds = tagPage.getData().stream()
                .filter(item -> item.getUserId() != null && item.getUserId() != 0)
                .map(Tag::getUserId).collect(Collectors.toList());
        List<TagUIData> tags = new ArrayList<>();
        GenericResult<List<User>> userResult = userManager.getByIds(userIds);
        Map<Integer, User> userMap = new HashMap<>();
        if (userResult.isValid()) {
            userMap = userResult.getData().stream()
                    .collect(Collectors.toMap(User::getId, item -> item));
        }
        for (Tag tag : tagPage.getData()) {
            tags.add(new TagUIData(tag, userMap.get(tag.getUserId())));
        }
        result.setData(new Page<>(tagPage.getTotalCount(), tags));
        return result;
    }

    @Override
    @PostMapping("/create")
    public NoneDataResult create(@RequestBody Tag tag) {
        return tagManager.create(tag);
    }

    @Override
    @PostMapping("/update")
    public NoneDataResult update(@RequestBody Tag tag) {
        return tagManager.update(tag);
    }

    @Override
    @PostMapping("/delete")
    public NoneDataResult delete(@RequestParam("ids") List<Integer> ids) {
        return tagManager.delete(ids);
    }
}
