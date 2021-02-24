package com.onezero.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class MD5Utils {

    public static final String md5Hex(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return DigestUtils.md5Hex(str);
    }
}
