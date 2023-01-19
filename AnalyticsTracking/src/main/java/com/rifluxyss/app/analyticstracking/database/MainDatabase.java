package com.rifluxyss.app.analyticstracking.database;

import androidx.room.RoomDatabase;

import com.rifluxyss.app.analyticstracking.dao.AnalyticsLogDao;

/**
 * Initialize the of the Room Database of Data Access Object class
 */
public abstract class MainDatabase extends RoomDatabase {

    public abstract AnalyticsLogDao analyticsLogDaoLogDao();
}
