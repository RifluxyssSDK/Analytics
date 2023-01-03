package com.rifluxyss.app.analyticstracking;


public class AnalyticsData {

    public final String scheduleDateTime;

    public final Number day;

    public String duration;

    public final String expireDateTime;

    public AnalyticsData(String localDateTime, Number day,String duration,String expireTime) {
        this.scheduleDateTime = localDateTime;
        this.day = day;
        this.duration = duration;
        this.expireDateTime = expireTime;
    }
}
