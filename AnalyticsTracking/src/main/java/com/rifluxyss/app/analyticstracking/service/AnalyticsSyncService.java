package com.rifluxyss.app.analyticstracking.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;


public class AnalyticsSyncService extends JobService {

    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();

        NotificationChannel channel = new NotificationChannel("1", "Data Sync Service", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        channel.setSound(null, null);
        channel.setShowBadge(false);
        notificationManager.createNotificationChannel(channel);

        startForeground(1, createDefaultNotification(getApplicationContext()));
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("status","check Data===> " + params.getJobId());
        Toast.makeText(getApplicationContext(), "Job Started", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("status","check Data Stop ===> " + params.getJobId());
        Toast.makeText(getApplicationContext(), "Job Stopped", Toast.LENGTH_SHORT).show();
        jobFinished(params,true);
        return true;
    }
    private Notification createDefaultNotification(Context context)
    {
        return createNotification("Analytics App", false,context);
    }

    private Notification createNotification(String title, boolean showProcess,Context context)
    {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle(title);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Sync-Channel").setStyle(bigTextStyle)
                .setWhen(System.currentTimeMillis()).setAutoCancel(false);
        return builder.build();
    }

}
