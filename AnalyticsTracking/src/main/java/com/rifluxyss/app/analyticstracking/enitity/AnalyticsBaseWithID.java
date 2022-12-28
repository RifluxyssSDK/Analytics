package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.Utils;

import java.time.LocalDateTime;

public class AnalyticsBaseWithID {

    @SuppressLint("HardwareIds")
    @ColumnInfo(name = "DeviceID")
    public String deviceID = Settings.Secure.getString(AppManager.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    @ColumnInfo(name = "IPAddress")
    public String ipAddress = new Utils().getIPAddress();

    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = LocalDateTime.now();

    @SuppressLint("NewApi")
    @ColumnInfo(name = "Day")
    public Number day = LocalDateTime.now().getDayOfWeek().getValue();

    @ColumnInfo(name = "DeviceModel")
    public String deviceModel = Utils.deviceModelCapitalized(Build.MANUFACTURER) + " " + Build.MODEL;

    @ColumnInfo(name = "DeviceSDKVersion")
    public int deviceSDKVersion = Build.VERSION.SDK_INT;


}
