package com.onezero.web;

import com.onezero.datastructure.NoneDataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @GetMapping("/login")
    public NoneDataResult login(HttpServletRequest request,
                                @RequestParam("userName") String userName,
                                @RequestParam("password") String password) {
        NoneDataResult result = new NoneDataResult();
        return result;
    }

    @PostMapping("/register")
    public NoneDataResult register() {
        NoneDataResult result = new NoneDataResult();
        return result;
    }
}
