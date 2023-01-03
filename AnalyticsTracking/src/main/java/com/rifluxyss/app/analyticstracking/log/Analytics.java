package com.rifluxyss.app.analyticstracking.log;

import static android.content.Context.JOB_SCHEDULER_SERVICE;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.widget.Toast;

import com.rifluxyss.app.analyticstracking.Utils;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.service.AnalyticsSyncService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Analytics extends AppManagerSingleton {

    private Context mContext;

    public Analytics() {
        this.mContext = AppManagerSingleton.getInstance().getContext();
    }

    public void insert(AnalyticsLog analyticsLog) {
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

    public void deleteAllLog() {
        localDatabase().analyticsLogDaoLogDao().deleteAllLog();
    }

    @SuppressLint("NewApi")
    public void deleteBeforeDayLog() {

        int analyticsLogs = localDatabase().analyticsLogDaoLogDao().readBeforeDateCount(LocalDateTime.now().minusDays(4));

        new Utils().isDeleteFile(Utils.fileName);
    }


    public void deleteBeforeDaysLog() throws IOException {

        boolean isExists = new Utils().isFilePresent(Utils.fileName);
        if (!isExists) {

            JobScheduler jobScheduler = (JobScheduler) AppManagerSingleton.getInstance().getContext().getSystemService(JOB_SCHEDULER_SERVICE);
            jobScheduler.cancelAll();

            ComponentName mComponentName = new ComponentName(AppManagerSingleton.getInstance().getContext(), AnalyticsSyncService.class);

            JobInfo.Builder builder = new JobInfo.Builder(2, mComponentName);
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
            builder.setRequiresCharging(true);
            builder.setPersisted(true);
            builder.setMinimumLatency(Utils.MINUTE_MILLIS); // 4 Days duration

            int scheduleStatus = jobScheduler.schedule(builder.build());

            String message = scheduleStatus == JobScheduler.RESULT_SUCCESS ? "Job Schedule Successfully" : "Job Schedule Failed!!";
            Toast.makeText(AppManagerSingleton.getInstance().getContext(), message, Toast.LENGTH_SHORT).show();

            new Utils().create(mContext,Utils.MINUTE_MILLIS);

        }

    }

}
