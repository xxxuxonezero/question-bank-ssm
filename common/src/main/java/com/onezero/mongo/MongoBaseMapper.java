package com.onezero.mongo;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
                    } else if (field.getName().equals("createdTime") || field.getName().equals("updatedTime")) {
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

//    private List<Document> datas2DocumentList(List<? extends Object> datas, Class clazz) {
//        List<Document> docs = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(datas)) {
//            Field[] fields = clazz.getDeclaredFields();
//            for (int i = 0; i < datas.size(); i++) {
//                try {
//                    for (Field field : fields) {
//                        Method method = clazz.getDeclaredMethod("get" + captureName(field.getName()));
//                        doc.put(field.getName(), method.invoke(data));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return docs;
//    }
//
//    private List<OptionData> docs2Datas(List<Document> docs) {
//        List<OptionData> options = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(docs)) {
//            for (Document doc : docs) {
//                OptionData option = new OptionData(doc.getString("label"), doc.getString("content"));
//                options.add(option);
//            }
//        }
//        return options;
//    }

}
