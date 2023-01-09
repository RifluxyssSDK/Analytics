package com.rifluxyss.app.analyticstracking.log;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import java.time.LocalDateTime;
import java.util.List;

public class Analytics extends AppManagerSingleton {

    private final Context mContext;

    public Analytics() {
        this.mContext = AppManagerSingleton.getInstance().getContext();
    }

    public void insert(AnalyticsLog analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    public void insert(List<AnalyticsLog> analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    public List<AnalyticsLog> getAllLog() {
        return localDatabase().analyticsLogDaoLogDao().getAll();
    }


    public LiveData<List<AnalyticsLog>> getDateTimeLogs(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().getSpecificLogs(localDateTime);
    }

    public LiveData<List<AnalyticsLog>> getDateWeekLogs(Number day) {
        return localDatabase().analyticsLogDaoLogDao().getBeforeSpecificLogs(day);
    }

    public LiveData<List<AnalyticsLog>> getSpecificDateTimeLogs(LocalDateTime startDayTime, LocalDateTime endDateTime) {
        return localDatabase().analyticsLogDaoLogDao().getSpecificDateTimeLogs(startDayTime,endDateTime);
    }

    public int deleteBeforeDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().deleteBefore(localDateTime);
    }

    public List<AnalyticsLog> deleteBeforeDateLog(Number day) {
        return localDatabase().analyticsLogDaoLogDao().readBeforeDateCount(day);
    }

    public void deleteLogs(List<AnalyticsLog> day) {
        localDatabase().analyticsLogDaoLogDao().deleteBeforeDays(day);
    }


    public void deleteAllLog() {
        localDatabase().analyticsLogDaoLogDao().deleteAllLog();
    }

    public List<AnalyticsLog> getListAnalyticsLocationRoute(String locationNumber, Number routeNumber) {
        return localDatabase().analyticsLogDaoLogDao().getListLocationRouteData(locationNumber,routeNumber);
    }

    public List<AnalyticsLog> getListAnalyticsUserId(String usrID) {
        return localDatabase().analyticsLogDaoLogDao().getListUserData(usrID);
    }

    public List<AnalyticsLog> getListAnalyticsHostID(String hostID) {
        return localDatabase().analyticsLogDaoLogDao().getListHostIDData(hostID);
    }
}
