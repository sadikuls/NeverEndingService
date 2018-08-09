package com.sadikul.NeverEndingService;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(this, NeverEndingService.class));
        } else {


            if(!Helper.isMyServiceRunning(NeverEndingService.class,this)){
                startService(new Intent(this, NeverEndingService.class));

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, NeverEndingService.class));
    }
}
