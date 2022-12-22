package com.rifluxyss.app.analyticstracking;

import androidx.room.RoomDatabase;

public abstract class MainDatabase extends RoomDatabase {

    public abstract AnalyticsLogDao analyticsLogDaoLogDao();
}
