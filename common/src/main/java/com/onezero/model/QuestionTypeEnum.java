package com.onezero.model;

import org.apache.commons.lang3.StringUtils;

public enum QuestionTypeEnum {
    SINGLE_CHOICE(1, "单选题"),
    MULTI_CHOICE(2, "不定项选择题/多选题"),
    SHOR_ANSWER_QUESTION(3, "简答题"),
    FILL_BLANK_QUESTION(4, "填空题"),
    ASK_ANSWER_QUESTION(5, "问答题"),
    PROGRAMMING_QUESTION(6, "编程题")
    ;

    private int id;
    private String desc;

    QuestionTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static int getId(String desc) {
        int id = 0;
        for (QuestionTypeEnum typeEnum: QuestionTypeEnum.values()) {
            if (typeEnum.getDesc().contains(desc)) {
                id = typeEnum.getId();
            }
        }
        return id;
    }
}
