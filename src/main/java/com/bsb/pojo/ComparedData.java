package com.bsb.pojo;

import java.util.List;

public class ComparedData {
    private String target;
    private List<Double> nationalData;
    private List<Double> positionData;
    private List<String> testTime;


    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Double> getNationalData() {
        return nationalData;
    }

    public void setNationalData(List<Double> nationalData) {
        this.nationalData = nationalData;
    }

    public List<Double> getPositionData() {
        return positionData;
    }

    public void setPositionData(List<Double> positionData) {
        this.positionData = positionData;
    }

    public List<String> getTestTime() {
        return testTime;
    }

    public void setTestTime(List<String> testTime) {
        this.testTime = testTime;
    }
}
