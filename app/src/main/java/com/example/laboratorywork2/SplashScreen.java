package com.example.laboratorywork2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {

    private boolean alreadyOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();

        handler.postDelayed(() -> {
            if(!alreadyOpen)
                startMainActivity();
        }, 3000);

        LinearLayout layout = findViewById(R.id.splashScreenLayout);
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