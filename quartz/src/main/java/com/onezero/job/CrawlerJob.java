package com.onezero.job;

import java.util.Map;

public class CrawlerJob extends AbstractJob {

    public CrawlerJob(String name) {
        super(name);
    }

    public CrawlerJob() {
        super();
    }

    @Override
    public void execute(Map<String, Object> params) {
        System.out.println(params.get("jobId"));
    }
}
