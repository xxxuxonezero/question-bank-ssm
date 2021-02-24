package com.onezero.mongo;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class MongoBaseMapper<T> implements MongoMapper<T>{
    @Override
    public Document toDocument(T data) {
        if (data != null) {
            Document doc = new MongoDocument();
            Class<?> clazz = data.getClass();
            Field[] declaredFields =
                    clazz.getDeclaredFields();
            try {
                for (Field field : declaredFields) {
                    Method method = clazz.getDeclaredMethod("get" + captureName(field.getName()));
                    if (field.getName().equals("id")) {
                        String id = (String) method.invoke(data);
                        if (StringUtils.isNotEmpty(id)) {
                            doc.put("_id", new ObjectId(id));
                        }
                    } else {
                        doc.put(field.getName(), method.invoke(data));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return doc;
        }
        return null;
    }

    private String captureName(String str) {
        if (str != null) {
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return str;
    }

}
