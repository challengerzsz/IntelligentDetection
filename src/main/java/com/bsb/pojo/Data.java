package com.bsb.pojo;

import java.util.Date;
import java.sql.Timestamp;

public class Data {
    private Integer id;
    private Date timestamp;
    private Double temperature;
    private Double humidity;
    private Double pm25;
    private Double pm10;
    private Double so2;
    private Double no2;
    private Double o3;
    private Double co;
    private Double aqi;
    private String status;


    public Data(Integer id, Timestamp timestamp, Double temperature, Double humidity, Double pm25, Double pm10, Double so2, Double no2, Double o3, Double co, Double aqi) {
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.so2 = so2;
        this.no2 = no2;
        this.o3 = o3;
        this.co = co;
        this.aqi = aqi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getO3() {
        return o3;
    }

    public void setO3(Double o3) {
        this.o3 = o3;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getAqi() {
        return aqi;
    }

    public void setAqi(Double aqi) {
        this.aqi = aqi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calculateStatus() {
        if (this.aqi >= 0 && this.aqi <= 50) this.status = "优";
        if (this.aqi > 50 && this.aqi <= 100) this.status = "良";
        if (this.aqi > 100 && this.aqi <= 150) this.status = "轻度污染";
        if (this.aqi > 150 && this.aqi <= 200) this.status = "中度污染";
        if (this.aqi > 200 && this.aqi <= 300) this.status = "重度污染";
        if (this.aqi > 300) this.status = "严重污染";
    }
}
