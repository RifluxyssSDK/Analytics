package com.rifluxyss.app.analyticstracking.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.time.LocalDateTime;
import java.util.List;

/** * Initialize the Data access Objects of AnalyticsLogDao */
@Dao
public interface AnalyticsLogDao {

    /** * @param log of AnalyticsLog Data of Object insert Data in Database */
    @Insert
    void insert(AnalyticsLog log);

    /** * @param logs of AnalyticsLog Data of List value in Database */
    @Insert
    void insert(List<AnalyticsLog> logs);

    /**
     * @param day is the Day of week value
     * @return filtered the Day of the week value based on the List<AnalyticsLog> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE Day = :day")
    List<AnalyticsLog> readBeforeDateCount(Number day);

    /** * @param deleteAnalyticsLogs of Logs Data in Database */
    @Delete
    void deleteBeforeDays(List<AnalyticsLog> deleteAnalyticsLogs);

    /**
     * @param eventTime is the LocalDateTime value
     * @return filtered the eventTime value based on the int value
     */
    @Query("DELETE FROM AnalyticsLog WHERE eventTime > :eventTime")
    int deleteBefore(LocalDateTime eventTime);

    /**
     * @param localDateTime of the LocalDateTime
     * @return the LiveData<List<AnalyticsLog>> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE EventTime <= :localDateTime")
    List<AnalyticsLog> getSpecificLogs(LocalDateTime localDateTime);

    /**
     * @param startDateTime of the LocalDateTime
     * @param endDateTime of the LocalDateTime
     * @return  the LiveData<List<AnalyticsLog>> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE EventTime >= :startDateTime LIKE EventTime <= :endDateTime")
    List<AnalyticsLog> getSpecificDateTimeLogs(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * @param startDay of the LocalDateTime
     * @param endDay of the LocalDateTime
     * @return  the LiveData<List<AnalyticsLog>> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE Day >= :startDay LIKE Day <= :endDay")
    List<AnalyticsLog> getSpecificDayLogs(Number startDay, Number endDay);

    /**
     * @param day of Number value
     * @return the LiveData<List<AnalyticsLog>> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE Day <= :day")
    List<AnalyticsLog> getBeforeSpecificLogs(Number day);

    /**
     * @param localNbr of the String value
     * @param routeNbr of the Number value
     * @return the List<AnalyticsLog> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE LocationNbr = :localNbr AND RouteNbr = :routeNbr")
    List<AnalyticsLog> getListLocationRouteData(String localNbr, Number routeNbr);

    /**
     * @param userID of the String value
     * @return the List<AnalyticsLog> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE UserId = :userID")
    List<AnalyticsLog> getListUserData(String userID);

    /**
     * @param hostID of the String value
     * @return the List<AnalyticsLog> value
     */
    @Query("SELECT * FROM AnalyticsLog WHERE HostId = :hostID")
    List<AnalyticsLog> getListHostIDData(String hostID);

    /**
     * @return the List<AnalyticsLog> value
     */
    @Query("SELECT * FROM AnalyticsLog")
    List<AnalyticsLog> getAll();

    /**
     * Delete the All logs Data of the Database
     */
    @Query("DELETE FROM AnalyticsLog")
    void deleteAllLog();

}
