package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AnalyticsLog extends AnalyticsBaseWithID {

    @ColumnInfo(name = "locationCode")
    public String locationCode;
    @ColumnInfo(name = "routeNo")
    public String routeNo;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "day")
    public int day = LocalDate.now().getDayOfWeek().getValue();
    @ColumnInfo(name = "userID")
    public String userId;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "eventTime")
    public LocalDateTime eventTime = LocalDateTime.now();
    @ColumnInfo(name = "eventNumber")
    public int eventNumber;
    @ColumnInfo(name = "message")
    public String message;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "additionalNumber")
    public float additionalNumber;
    @ColumnInfo(name = "hostId")
    public String hostId;

}
