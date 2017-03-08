package com.example.norstar.guide;

import android.content.Context;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SuccessActivity extends AppCompatActivity {

    //屏幕常亮
    PowerManager powerManager = null;
    PowerManager.WakeLock wakeLock = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        this.powerManager = (PowerManager)this
                .getSystemService(Context.POWER_SERVICE);
        this.wakeLock = this.powerManager.newWakeLock(
                PowerManager.FULL_WAKE_LOCK,"My Lock");


    }

    @Override
    protected void onResume() {
        super.onResume();
        this.wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.wakeLock.release();
    }
}
