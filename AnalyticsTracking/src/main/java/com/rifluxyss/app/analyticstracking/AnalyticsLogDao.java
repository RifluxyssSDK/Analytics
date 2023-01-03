package com.rifluxyss.app.analyticstracking;

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

    @Query("SELECT * FROM AnalyticsLog")
    List<AnalyticsLog> getAll();

    @Query("DELETE FROM AnalyticsLog")
    void deleteAllLog();

}
