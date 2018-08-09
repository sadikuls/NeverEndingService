package com.sadikul.NeverEndingService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class NeverEndingService extends Service{


    //this method will called if the service bind to any acitivity
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //this method will called when service is created
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //this method will called when service is created
    @Override
    public void onCreate() {
        super.onCreate();
    }

    //this method will called if service is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //this method will called if app is killed
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }
}
