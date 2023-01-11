package com.rifluxyss.app.analyticstracking.database;

import androidx.room.RoomDatabase;

import com.rifluxyss.app.analyticstracking.dao.AnalyticsLogDao;

public abstract class MainDatabase extends RoomDatabase {

    public abstract AnalyticsLogDao analyticsLogDaoLogDao();
}
