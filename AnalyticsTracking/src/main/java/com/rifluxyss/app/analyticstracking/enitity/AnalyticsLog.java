package com.rifluxyss.app.analyticstracking.enitity;

import android.annotation.SuppressLint;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.Utils;

@Entity
public class AnalyticsLog extends AnalyticsBaseWithID {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "HostId")
    public String hostId;
    @ColumnInfo(name = "UserId")
    public String userID;
    @ColumnInfo(name = "LocationNbr")
    public String locationNbr;
    @ColumnInfo(name = "RouteNbr")
    public Number routNbr;
    @SuppressLint("NewApi")
    @ColumnInfo(name = "EventNbr")
    public String eventNbr;
    @ColumnInfo(name = "AddtlDesc")
    public String addtlDesc;
    @ColumnInfo(name = "AddtlNbr")
    public Number addtlNbr;

}
