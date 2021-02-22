package com.onezero.utils;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SIGN_KEY = "onezeroIdentityJWT";
    private static final String PAYLOAD = "payload";
    private static final String HEADER = "header";
    private static final String SIGNATURE = "signature";

    public static String generateJwt(Object o) {
        try {
            ObjectMapper om = new ObjectMapper();
            String objStr = om.writeValueAsString(o);
            JwtBuilder builder = Jwts.builder()
                    .setPayload(objStr)
                    .signWith(SignatureAlgorithm.HS256, SIGN_KEY);
            return builder.compact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getObject(String jwt, Class c) {
        if (StringUtils.isEmpty(jwt)) {
            return null;
        }
        boolean isTrue = isTrueJwt(jwt);
        if (isTrue) {
            String content = getContent(jwt);
            if (!StringUtils.isEmpty(content)) {
                ObjectMapper om = new ObjectMapper();
                try {
                    Object o = om.readValue(content, c);
                    return o;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String getContent(String jwt) {
        Map<String, String> map = getJwtMap(jwt);
        String content = null;
        String payload = map.get(PAYLOAD);
        if (!StringUtils.isEmpty(payload)) {
            content = new String(Base64.getDecoder().decode(payload.getBytes()));
        }
        return content;
    }

    private static Map<String, String> getJwtMap(String jwt) {
        if (StringUtils.isEmpty(jwt)) {
            return null;
        }
        String[] str = jwt.split("\\.");
        if (str.length < 3) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put(HEADER, str[0]);
        map.put(PAYLOAD, str[1]);
        map.put(SIGNATURE, str[2]);
        return map;
    }

    private static boolean isTrueJwt(String jwt) {
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(jwt);
            if (claimsJws != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
