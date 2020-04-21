package com.rrokullia.pluscomputers.mosque.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.Calendar;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent1 = new Intent(this, ShortTimeEntryReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent1,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        Calendar c = Calendar.getInstance();
////        c.set(Calendar.HOUR_OF_DAY, 11);
////        c.set(Calendar.MINUTE, 22);
////        c.set(Calendar.SECOND, 0);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),AlarmManager.INTERVAL_FIFTEEN_MINUTES,
//                pendingIntent);

        return START_STICKY;
    }

}
