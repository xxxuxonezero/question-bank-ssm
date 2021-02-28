package com.onezero.mongo;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MongoBaseMapper<T> implements MongoMapper<T> {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

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
                    } else if (field.getName().equals("createdTime") || field.getName().equals("updatedTime")) {
                    } else {
                        doc.put(getMongoFieldName(field.getName()), method.invoke(data));
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

    private String getMongoFieldName(String str) {
        if (StringUtils.isNotEmpty(str)) {
            Matcher matcher = humpPattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(sb);
            str = sb.toString();
        }
        return str;
    }

    public List<Document> datas2DocumentList(List<? extends Object> datas, Class clazz) {
        List<Document> docs = null;
        if (CollectionUtils.isNotEmpty(datas)) {
            docs = new ArrayList<>();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < datas.size(); i++) {
                try {
                    Document doc = new MongoDocument();
                    for (Field field : fields) {
                        Method method = clazz.getDeclaredMethod("get" + captureName(field.getName()));
                        doc.put(getMongoFieldName(field.getName()), method.invoke(datas.get(i)));
                    }
                    docs.add(doc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return docs;
    }

}
