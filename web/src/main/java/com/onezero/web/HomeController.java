package com.onezero.web;

import com.onezero.bll.account.User;
import com.onezero.bll.account.UserManager;
import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.web.data.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/login")
    public NoneDataResult login(HttpServletRequest request,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password) {
        NoneDataResult result = new NoneDataResult();
        GenericResult<User> userResult = userManager.getUserByEmailAndPassword(email, password);
        if (userResult.isNotValid()) {
            result.setCode(Code.EMAIL_OR_PASSWORD);
            return result;
        }
        Identity identity = new Identity(userResult.getData());
        return result;
    }

    @PostMapping("/register")
    public NoneDataResult register() {
        NoneDataResult result = new NoneDataResult();
        return result;
    }

    @PostMapping("/logout")
    public void logout() {

    }

}
