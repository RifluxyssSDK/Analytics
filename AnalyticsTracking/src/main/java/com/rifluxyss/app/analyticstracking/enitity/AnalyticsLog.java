package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.common.DateTimeUtils;

import java.time.LocalDateTime;

/** * Initialize the of the Database Entity class */
@SuppressWarnings({"unused", "UnusedReturnValue"})
@Entity
public class AnalyticsLog {

    /** * Initialize the int variable of ID */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    /** * Initialize the LocalDateTime variable of eventTime */
    @ColumnInfo(name = "EventTime")
    public LocalDateTime eventTime = new DateTimeUtils().getLocalDateTime();

    /** * Initialize the String variable of hostId */
    @SuppressLint("HardwareIds")
    @ColumnInfo(name = "HostId")
    public String hostId = Settings.Secure.getString(AppManagerSingleton.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    /** * Initialize the String variable of userID */
    @ColumnInfo(name = "UserId")
    public String userID;

    /** * Initialize the String variable of locationNbr */
    @ColumnInfo(name = "LocationNbr")
    public String locationNbr;

    /** * Initialize the Number variable of routNbr */
    @ColumnInfo(name = "RouteNbr")
    public Number routNbr;

    /** * Initialize the Number variable of day */
    @ColumnInfo(name = "Day")
    public Number day = new DateTimeUtils().getDayOfWeek();

    /** * Initialize the String variable of logger */
    @ColumnInfo(name = "Logger")
    public String logger;

    /** * Initialize the String variable of eventNbr */
    @ColumnInfo(name = "EventNbr")
    public String eventNbr;

    /** * Initialize the String variable of addtlDesc */
    @ColumnInfo(name = "AddtlDesc")
    public String addtlDesc;

    /** * Initialize the Number variable of addtlNbr */
    @ColumnInfo(name = "AddtlNbr")
    public Number addtlNbr;

}
