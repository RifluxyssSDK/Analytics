package com.rifluxyss.app.analyticstracking.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.time.LocalDateTime;
import java.util.List;

@Dao
public interface AnalyticsLogDao {

    @Insert
    void insert(AnalyticsLog log);

    @Insert
    void insert(List<AnalyticsLog> logs);

    @Query("SELECT * FROM AnalyticsLog WHERE Day = :day")
    List<AnalyticsLog> readBeforeDateCount(Number day);

    @Delete
    void deleteBeforeDays(List<AnalyticsLog> deleteAnalyticsLogs);

    @Query("DELETE FROM AnalyticsLog WHERE eventTime > :eventTime")
    int deleteBefore(LocalDateTime eventTime);

    @Query("SELECT * FROM AnalyticsLog WHERE EventTime <= :localDateTime")
    LiveData<List<AnalyticsLog>> getSpecificLogs(LocalDateTime localDateTime);

    @Query("SELECT * FROM AnalyticsLog WHERE EventTime <= :startDateTime LIKE EventTime >= :endDateTime")
    LiveData<List<AnalyticsLog>> getSpecificDateTimeLogs(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Query("SELECT * FROM AnalyticsLog WHERE Day <= :day")
    LiveData<List<AnalyticsLog>> getBeforeSpecificLogs(Number day);

    @Query("SELECT * FROM AnalyticsLog WHERE LocationNbr = :localNbr AND RouteNbr = :routeNbr")
    List<AnalyticsLog> getListLocationRouteData(String localNbr, Number routeNbr);

    @Query("SELECT * FROM AnalyticsLog WHERE UserId = :userID")
    List<AnalyticsLog> getListUserData(String userID);

    @Query("SELECT * FROM AnalyticsLog WHERE HostId = :hostID")
    List<AnalyticsLog> getListHostIDData(String hostID);

    @Query("SELECT * FROM AnalyticsLog")
    List<AnalyticsLog> getAll();

    @Query("DELETE FROM AnalyticsLog")
    void deleteAllLog();

}
