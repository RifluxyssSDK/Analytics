package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.rifluxyss.app.analyticstracking.Utils;
import java.time.LocalDateTime;

@Entity
public class AnalyticsLog extends AnalyticsBaseWithID {

    @ColumnInfo(name = "HostId")
    public String hostId;
    @ColumnInfo(name = "UserId")
    public String userID;
    @ColumnInfo(name = "LocationNbr")
    public String locationNbr;
    @ColumnInfo(name = "RouteNbr")
    public Number routNbr;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "Day")
    public Number day = LocalDateTime.now().getDayOfWeek().getValue() - 1;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = LocalDateTime.now();
    @ColumnInfo(name = "EventNbr")
    public String eventNbr;
    @ColumnInfo(name = "AddtlDesc")
    public String addtlDesc;
    @ColumnInfo(name = "AddtlNbr")
    public Number addtlNbr;
    @ColumnInfo(name = "DeviceID")
    public String deviceID;
    @ColumnInfo(name = "DeviceModel")
    public String deviceModel = Utils.deviceModelCapitalized(Build.MANUFACTURER) + " " + Build.MODEL;

}
