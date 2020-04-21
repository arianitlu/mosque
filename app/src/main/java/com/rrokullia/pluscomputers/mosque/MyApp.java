package com.rrokullia.pluscomputers.mosque;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.onesignal.OneSignal;
import com.rrokullia.pluscomputers.mosque.alarmmanager.MyService;
import com.rrokullia.pluscomputers.mosque.alarmmanager.ShortTimeEntryReceiver;
import com.rrokullia.pluscomputers.mosque.worker.MyWorker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

//-------------------------------------------------------------------------
//        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class,
//                20, TimeUnit.MINUTES).build();
//        WorkManager.getInstance().enqueue(periodicWorkRequest);
//-------------------------------------------------------------------------
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(this, ShortTimeEntryReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.HOUR_OF_DAY, 10);
//        c.set(Calendar.MINUTE, 56);
//        c.set(Calendar.SECOND, 0);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),AlarmManager.INTERVAL_FIFTEEN_MINUTES,
//                pendingIntent);
//-------------------------------------------------------------------------

//        startService(new Intent(this, MyService.class));


    }
}
