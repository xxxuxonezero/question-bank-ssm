package com.onezero.web.admin;

import com.onezero.bll.account.User;
import com.onezero.bll.account.UserManager;
import com.onezero.bll.job.BatchJobManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.web.data.Identity;
import com.onezero.web.data.UserUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/getList")
    public GenericResult<Page<UserUIData>> getList(@RequestParam(value = "type", required = false) Integer type,
                                                   @RequestParam(value = "email", required = false) String email,
                                                   @RequestParam(value = "displayName", required = false) String displayName,
                                                   @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        GenericResult<Page<UserUIData>> result = new GenericResult<>();
        GenericResult<Page<User>> pageGenericResult = userManager.search(email, null, type, page, pageSize);
        if (pageGenericResult.isNotValid()) {
            result.setCode(result.getCode());
            return result;
        }
        Page<User> userPage = pageGenericResult.getData();
        List<User> users = userPage.getData();
        List<UserUIData> userUIDataList = users.stream().map(UserUIData::new).collect(Collectors.toList());
        result.setData(new Page<>(userPage.getTotalCount(), userUIDataList));
        return result;
    }

    @PostMapping("/create")
    public NoneDataResult create(@RequestBody User user) {
        return userManager.create(user);
    }

    @PostMapping("/update")
    public NoneDataResult update(@RequestBody User user) {
        return userManager.update(user);
    }

    @PostMapping("/delete")
    public NoneDataResult delete(@RequestParam("ids") List<Integer> ids) {
        return userManager.delete(ids);
    }
}
