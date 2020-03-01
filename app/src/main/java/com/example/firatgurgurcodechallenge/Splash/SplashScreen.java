package com.example.firatgurgurcodechallenge.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.firatgurgurcodechallenge.MainActivity;
import com.example.firatgurgurcodechallenge.R;
import com.example.firatgurgurcodechallenge.Statics;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Statics.setTransparetStatusBar(SplashScreen.this);

        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openApp = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(openApp);
                finish();
            }
        }, 1200);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
