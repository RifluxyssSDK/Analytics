package com.rifluxyss.app.analyticstracking.log;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static java.util.concurrent.TimeUnit.MINUTES;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.service.AnalyticsSyncService;

import java.time.LocalDateTime;
import java.util.List;

public class Analytics extends AppManager {

    public void insert(AnalyticsLog analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    public void insertLog(List<AnalyticsLog> analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    public List<AnalyticsLog> getLog() {
        return localDatabase().analyticsLogDaoLogDao().getAll();
    }

    public List<AnalyticsLog> getDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().readBefore(localDateTime);
    }

    public List<AnalyticsLog> getAfterDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().readAfter(localDateTime);
    }

    public int deleteBeforeDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().deleteBefore(localDateTime);
    }

    public int deleteAfterDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().deleteAfter(localDateTime);
    }

    public void deleteAllLog() {
        localDatabase().analyticsLogDaoLogDao().deleteAllLog();
    }


    @SuppressLint({"NewApi", "LocalSuppress"})
    public void deleteBeforeDaysLog(Context context) {

        JobScheduler scheduler = (JobScheduler) context.getSystemService(JOB_SCHEDULER_SERVICE);
        Toast.makeText(context, "Job Service Initiated", Toast.LENGTH_SHORT).show();

        JobInfo profileSyncJob = new JobInfo.Builder(2,
                new ComponentName(context, AnalyticsSyncService.class))
                .setPeriodic(MINUTES.toMillis(2),MINUTES.toMillis(1))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(true)
                .build();

        scheduler.cancel(2);
        int status = scheduler.schedule(profileSyncJob);
        if (status == JobScheduler.RESULT_SUCCESS) {
            Log.e("status", "Job scheduled successfully");
        } else {
            Log.e("status", "Job scheduling failed");
        }
    }

}
