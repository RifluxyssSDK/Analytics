package com.rifluxyss.app.analyticstracking.log;

import androidx.lifecycle.LiveData;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics extends AppManagerSingleton {


    /**
     * Instantiates a new Analytics.
     */
    public Analytics() {
    }

    /**
     * Insert.
     *
     * @param analyticsLog the analytics log
     */
    public void insert(AnalyticsLog analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    /**
     * Insert.
     *
     * @param analyticsLog the analytics log
     */
    public void insert(List<AnalyticsLog> analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    /**
     * Gets all log.
     *
     * @return the all log
     */
    public List<AnalyticsLog> getAllLog() {
        return localDatabase().analyticsLogDaoLogDao().getAll();
    }


    /**
     * Gets date time logs.
     *
     * @param localDateTime the local date time
     * @return the date time logs
     */
    public List<AnalyticsLog> getDateTimeLogs(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().getSpecificLogs(localDateTime);
    }

    /**
     * Gets date week logs.
     *
     * @param day the day
     * @return the date week logs
     */
    public List<AnalyticsLog> getDateWeekLogs(Number day) {
        return localDatabase().analyticsLogDaoLogDao().getBeforeSpecificLogs(day);
    }

    /**
     * Gets specific date time logs.
     *
     * @param startDayTime the start day time
     * @param endDateTime  the end date time
     * @return the specific date time logs
     */
    public List<AnalyticsLog> getSpecificDateTimeLogs(LocalDateTime startDayTime, LocalDateTime endDateTime) {
        return localDatabase().analyticsLogDaoLogDao().getSpecificDateTimeLogs(startDayTime,endDateTime);
    }

    /**
     * Gets specific date time logs.
     *
     * @param startDayTime the start day time
     * @param endDateTime  the end date time
     * @return the specific date time logs
     */
    public List<AnalyticsLog> getSpecificDaysLogs(Number startDayTime, Number endDateTime) {
        return localDatabase().analyticsLogDaoLogDao().getSpecificDayLogs(startDayTime,endDateTime);
    }

    /**
     * Delete before date log int.
     *
     * @param localDateTime the local date time
     * @return the int
     */
    public int deleteBeforeDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().deleteBefore(localDateTime);
    }

    /**
     * Delete before date log list.
     *
     * @param day the day
     * @return the list
     */
    public List<AnalyticsLog> deleteBeforeDateLog(Number day) {
        return localDatabase().analyticsLogDaoLogDao().readBeforeDateCount(day);
    }

    /**
     * Delete logs.
     *
     * @param day the day
     */
    public void deleteLogs(List<AnalyticsLog> day) {
        localDatabase().analyticsLogDaoLogDao().deleteBeforeDays(day);
    }


    /**
     * Delete all log.
     */
    public void deleteAllLog() {
        localDatabase().analyticsLogDaoLogDao().deleteAllLog();
    }

    /**
     * Gets list analytics location route.
     *
     * @param locationNumber the location number
     * @param routeNumber    the route number
     * @return the list analytics location route
     */
    public List<AnalyticsLog> getListAnalyticsLocationRoute(String locationNumber, Number routeNumber) {
        return localDatabase().analyticsLogDaoLogDao().getListLocationRouteData(locationNumber,routeNumber);
    }

    /**
     * Gets list analytics user id.
     *
     * @param usrID the usr id
     * @return the list analytics user id
     */
    public List<AnalyticsLog> getListAnalyticsUserId(String usrID) {
        return localDatabase().analyticsLogDaoLogDao().getListUserData(usrID);
    }

    /**
     * Gets list analytics host id.
     *
     * @param hostID the host id
     * @return the list analytics host id
     */
    public List<AnalyticsLog> getListAnalyticsHostID(String hostID) {
        return localDatabase().analyticsLogDaoLogDao().getListHostIDData(hostID);
    }
}
