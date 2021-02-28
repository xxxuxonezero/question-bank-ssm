package com.onezero.mongo.data;

public class SampleData {
    private String inputData;
    private String outputData;

    public SampleData() {
    }

    public SampleData(String inputData, String outputData) {
        this.inputData = inputData;
        this.outputData = outputData;
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
