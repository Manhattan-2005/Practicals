package com.shiva;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class CustomService extends Service {
    private static final String TAG = "CustomService";
    private String serviceName;
    private boolean flag;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.hasExtra("name")) {
            serviceName = intent.getStringExtra("name");
        } else {
            serviceName = "Shivpratap";
        }

        if (!flag) {
            flag = true;
            startLoggingThread();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
        Log.d(TAG, "Service destroyed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startLoggingThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int digit = 0;
                while (flag) {
                    Log.d(TAG, "Name: " + serviceName + digit);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    digit++;
                }
            }
        }).start();
    }
}
