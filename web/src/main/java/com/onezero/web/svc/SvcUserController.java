package com.onezero.web.svc;

import com.onezero.auth.AuthUtils;
import com.onezero.bll.account.User;
import com.onezero.bll.account.UserManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.web.data.Identity;
import com.onezero.web.data.UserUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Svc/user")
public class SvcUserController {
    @Autowired
    private UserManager userManager;

    /**
     * 每次发送请求前，获取用户信息，总是去数据库中获取最新的信息,避免更新时无法及时更新
     * @param request
     * @return
     */
    @GetMapping("/getUserInfo")
    public GenericResult<UserUIData> getUserInfo(HttpServletRequest request) {
        GenericResult<UserUIData> result = new GenericResult<>();
        Identity identity = AuthUtils.getIdentity(request);
        if (identity == null) {
            return result;
        }
        GenericResult<User> userResult = userManager.getById(identity.getId());
        if (userResult.isValid()) {
            result.setData(new UserUIData(userResult.getData()));
        }
        return result;
    }
}
