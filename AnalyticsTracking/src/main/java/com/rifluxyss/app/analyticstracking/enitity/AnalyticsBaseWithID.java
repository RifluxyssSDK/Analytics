package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;

import androidx.room.ColumnInfo;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.Utils;

import java.time.LocalDateTime;

public class AnalyticsBaseWithID {

    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = LocalDateTime.now();

    @SuppressLint("NewApi")
    @ColumnInfo(name = "Day")
    public Number day = LocalDateTime.now().getDayOfWeek().getValue();

}
