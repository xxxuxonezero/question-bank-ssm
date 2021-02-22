package com.onezero.job;

import java.util.Map;

public class SendNotificationJob extends AbstractJob{

    public SendNotificationJob(String name) {
        super(name);
    }

    public SendNotificationJob() {
    }

    @Override
    public void execute(Map<String, Object> params) {
        System.out.println(params.get("jobId"));
    }
}
