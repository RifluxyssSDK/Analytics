package com.rifluxyss.app.analyticstracking.log;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static java.util.concurrent.TimeUnit.MINUTES;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
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
        scheduler.cancelAll();

        ComponentName mComponentName = new ComponentName(context,AnalyticsSyncService.class);

        JobInfo.Builder builder = new JobInfo.Builder(2,mComponentName);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(true);
        builder.setPersisted(true);
        builder.setMinimumLatency(MINUTES.toMillis(1)); // wait at least

        //HOURS.toDays(1)
        int scheduleStatus = scheduler.schedule(builder.build());

        if (scheduleStatus == JobScheduler.RESULT_SUCCESS) {
            Toast.makeText(context, "Job Schedule Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Job Schedule Failed!!", Toast.LENGTH_SHORT).show();
        }

    }

}
