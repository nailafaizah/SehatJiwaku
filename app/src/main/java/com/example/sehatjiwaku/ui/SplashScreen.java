package com.example.sehatjiwaku.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sehatjiwaku.R;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //delay splash screen selama 3 detik
        new Handler().postDelayed(new Runnable () {
            @Override
            public void run(){
                Intent i = new Intent(SplashScreen.this, Opening1.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}