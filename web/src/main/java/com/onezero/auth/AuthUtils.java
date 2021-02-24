package com.onezero.auth;

import com.onezero.model.Constant;
import com.onezero.utils.JWTUtils;
import com.onezero.web.data.Identity;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthUtils {
    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        String value = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    public static Identity getIdentify(HttpServletRequest request) {
        String jwt = getCookie(request, Constant.IDENTITY);
        return (Identity) JWTUtils.getObject(jwt, Identity.class);
    }

    public static void setJWTCookie(HttpServletRequest request, String key, Object o) {

    }
}
