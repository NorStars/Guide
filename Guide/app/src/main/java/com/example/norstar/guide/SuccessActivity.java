package com.example.norstar.guide;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SuccessActivity extends AppCompatActivity {

    //此为主界面

    //屏幕常亮
    PowerManager powerManager = null;
    PowerManager.WakeLock wakeLock = null;

    //界面控件注册
    private ImageButton imageButton;
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        this.powerManager = (PowerManager)this
                .getSystemService(Context.POWER_SERVICE);
        this.wakeLock = this.powerManager.newWakeLock(
                PowerManager.FULL_WAKE_LOCK,"My Lock");

        init();


    }

    public void init(){
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        imageButton.setOnClickListener(new btnListener());
        button1.setOnClickListener(new btnListener());
        button2.setOnClickListener(new btnListener());
        button3.setOnClickListener(new btnListener());

    }
    class btnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.imageButton:
                    startActivity(new Intent(SuccessActivity.this,CartoonActivity.class));
                    break;
                case R.id.button1:
                    break;
                case R.id.button2:
                    break;
                case R.id.button3:
                    break;
                default:
                    break;
            }
        }
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
