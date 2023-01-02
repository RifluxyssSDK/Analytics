package com.rifluxyss.app.analyticstracking;

import java.time.LocalDateTime;

public class AnalyticsData {

    public final String localDateTime;

    public final Number day;

    public AnalyticsData(String localDateTime, Number day) {
        this.localDateTime = localDateTime;
        this.day = day;
    }
}
