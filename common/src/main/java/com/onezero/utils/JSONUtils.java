package com.onezero.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

public class JSONUtils {

    private static final ObjectMapper om = new ObjectMapper();

    static {
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static final Object toObject(String s, Class clazz) {
        Object o = null;
        if (StringUtils.isEmpty(s) || clazz == null) {
            return o;
        }
        try {
           o = om.readValue(s, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public static final String toJson(Object o) {
        String s = null;
        if (o == null) {
            return s;
        }
        try {
             s = om.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
