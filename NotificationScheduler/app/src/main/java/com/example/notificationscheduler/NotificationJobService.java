package com.example.notificationscheduler;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationJobService extends JobService
{
    NotificationManager mNotificationManager;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification+channel";

    @Override
    public boolean onStartJob(JobParameters jobParameters)
    {
        createNotificationChannel();
        PendingIntent contentPendingIntent = PendingIntent.getActivity(this,0,
                new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentIntent(contentPendingIntent)
                .setContentTitle("Job Service")
                .setContentText("Job ran to completion")
                .setSmallIcon(R.drawable.ic_job)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        mNotificationManager.notify(0,builder.build());

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters)
    {
        return false;
    }

    public void createNotificationChannel()
    {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Job Service Notification",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Job Service");

            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
