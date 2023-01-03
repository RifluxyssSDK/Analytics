package com.rifluxyss.app.analyticstracking;

import java.time.LocalDateTime;

public class AnalyticsData {

    public final String localDateTime;

    public final Number day;

    public String duration;

    public AnalyticsData(String localDateTime, Number day,String duration) {
        this.localDateTime = localDateTime;
        this.day = day;
        this.duration = duration;
    }
}
