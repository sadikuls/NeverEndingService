package com.sadikul.NeverEndingService;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

public class NeverEndingService extends Service {

    private boolean isRunning;
    private Context context;
    private Thread backgroundThread;

    Runnable runnable = null;
    Handler handler = null;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {



    }





    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        sendBroadcastForStartService();

        Log.e("TEST","on destroy");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.context = this;
        handler = new Handler();
        handler.postDelayed(  runnable = new Runnable() {
            public void run() {
                sendBroadcastForMessage();
                handler.postDelayed(runnable,2*1000);

            }
        }, 2*2000);

        return START_STICKY;
    }

/*    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);

        Log.e("TEST","on task removed");
        Intent alarm = new Intent(this, AlarmReceiver.class);
        boolean alarmRunning = (PendingIntent.getBroadcast(this, 0, alarm, PendingIntent.FLAG_NO_CREATE) != null);

        if(alarmRunning == false) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarm, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            //alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 5000, pendingIntent);
            alarmManager.set(AlarmManager.RTC_WAKEUP, 5000, pendingIntent);

        }
    }*/





    @Override
    public void onTaskRemoved(Intent rootIntent) {
        stopSelf();
        sendBroadcastForStartService();
        super.onTaskRemoved(rootIntent);
    }

    //Broadcast for starting service
    private void sendBroadcastForStartService() {
        Intent broadcastIntent = new Intent("com.remote.connectivity.Receiver.RestartSensor");
        sendBroadcast(broadcastIntent);
    }

    //Broadcast for starting service
    private void sendBroadcastForMessage() {
        Intent broadcastIntent = new Intent("com.remote.connectivity.Receiver.Message");
        sendBroadcast(broadcastIntent);
    }




}