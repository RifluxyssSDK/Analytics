package com.rifluxyss.app.analyticstracking.enitity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class AnalyticsBaseWithID {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
}
