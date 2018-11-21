package com.example.pluscomputers.mosque.Utilities;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.onesignal.OneSignal;

public class MyService extends Service {

        @Override
        public void onCreate() {
            super.onCreate();
            OneSignal.startInit(this)
                    .setNotificationOpenedHandler(new OnClickSignal(this))
                    .init();
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            OneSignal.startInit(this)
                    .setNotificationOpenedHandler(new OnClickSignal(this))
                    .init();
            return START_STICKY;
        }

        @SuppressWarnings("deprecation")
        @Override
        public void onStart(Intent intent, int startId) {
            super.onStart(intent, startId);
        }

    }

