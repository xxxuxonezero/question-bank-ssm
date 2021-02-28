package com.onezero.bll.question.oj;

import com.onezero.mongo.data.SampleData;

public class Sample {
    private String inputData;
    private String outputData;

    public Sample(SampleData data) {
        if (data != null) {
            this.inputData = data.getInputData();
            this.outputData = data.getOutputData();
        }
    }

    public SampleData toData() {
        SampleData data = new SampleData();
        data.setInputData(this.inputData);
        data.setOutputData(this.outputData);
        return data;
    }

    public Sample() {
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getOutputData() {
        return outputData;
    }

    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }
}
