package com.example.norstar.guide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends AppCompatActivity {
    private Boolean guide;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        Handler handler = new Handler();
        //当计时结束,跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    SharedPreferences sp = getSharedPreferences("sp_guide", Context.MODE_WORLD_READABLE);
                    guide = sp.getBoolean("Guide",true);
                    if(guide == false) {
                        Intent intent = new Intent(WelcomeActivity.this, SuccessActivity.class);
                        startActivity(intent);
                        WelcomeActivity.this.finish();
                    }
                    else {
                        startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                    }

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("Guide",false);
                    editor.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000);
    }

}
