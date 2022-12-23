package com.rifluxyss.app.analyticstracking.log;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static java.util.concurrent.TimeUnit.MINUTES;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.service.AnalyticsSyncService;

import org.joda.time.DateTime;

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


        ComponentName mComponentName = new ComponentName(context,AnalyticsSyncService.class);

        JobInfo.Builder builder = new JobInfo.Builder(2,mComponentName);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //builder.setPeriodic(15 * 60 * 1000, 5 * 60 *1000);
            builder.setPeriodic(MINUTES.toMillis(2),MINUTES.toMillis(1));
        } else {
            builder.setPeriodic(MINUTES.toMillis(2));
        }

        JobScheduler scheduler = (JobScheduler) context.getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(builder.build());

    }

}
