package com.sadikul.NeverEndingService;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("TEST", "receiver  is working on background");


        if (!Helper.isMyServiceRunning(NeverEndingService.class, context)) {
            context.startService(new Intent(context, NeverEndingService.class));

        }


    }
}