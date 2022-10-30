package com.example.reactiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

    private boolean alreadyOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            if(!alreadyOpen)
                startMainActivity();
        }, 3000);

        RelativeLayout layout = findViewById(R.id.splashScreenLayout);
        layout.setOnClickListener((View view)-> startMainActivity());
    }

    private void startMainActivity()
    {
        alreadyOpen = true;
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}