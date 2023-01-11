package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.common.DateTimeUtils;
import com.rifluxyss.app.analyticstracking.common.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
public class AnalyticsLog {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = new DateTimeUtils().getLocalDateTime();
    @SuppressLint("HardwareIds")
    @ColumnInfo(name = "HostId")
    public String hostId = Settings.Secure.getString(AppManagerSingleton.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    @ColumnInfo(name = "UserId")
    public String userID;
    @ColumnInfo(name = "LocationNbr")
    public String locationNbr;
    @ColumnInfo(name = "RouteNbr")
    public Number routNbr;
    @ColumnInfo(name = "Day")
    public Number day = new DateTimeUtils().getWeekOfDay();
    @SuppressLint("NewApi")
    @ColumnInfo(name = "Logger")
    public String logger;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventNbr")
    public String eventNbr;
    @ColumnInfo(name = "AddtlDesc")
    public String addtlDesc;
    @ColumnInfo(name = "AddtlNbr")
    public Number addtlNbr;

}
