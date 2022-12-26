package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.rifluxyss.app.analyticstracking.Utils;

import java.time.LocalDateTime;

public class AnalyticsBaseWithID {

    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = LocalDateTime.now();

    @SuppressLint("NewApi")
    @ColumnInfo(name = "Day")
    public Number day = LocalDateTime.now().getDayOfWeek().getValue();

    @ColumnInfo(name = "DeviceModel")
    public String deviceModel = Utils.deviceModelCapitalized(Build.MANUFACTURER) + " " + Build.MODEL;

    @ColumnInfo(name = "DeviceOS")
    public String deviceOS = Build.VERSION.CODENAME.substring(0,1);


}
