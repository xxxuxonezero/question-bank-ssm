package com.onezero.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractJob{
    private String name;

    public abstract void execute(Map<String, Object> params);

    public Map<String, Object> parseParams(String params) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotEmpty(params)) {
            ObjectMapper om = new ObjectMapper();
            try {
                map = om.readValue(params, Map.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public void stop(){

    }

    public AbstractJob(String name) {
        this.name = name;
    }

    public AbstractJob() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
