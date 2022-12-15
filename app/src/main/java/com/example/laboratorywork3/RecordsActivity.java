package com.example.laboratorywork3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.laboratorywork3.observer.Observer;
import com.example.laboratorywork3.threads.WriteAndReadThreads;

import java.io.Serializable;

public class RecordsActivity extends AppCompatActivity implements Observer, Serializable {

    private static transient TextView textRecords;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        textRecords = findViewById(R.id.records);
        readFile();
        findViewById(R.id.home_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void update(String message) {
        textRecords.setText(message);
    }

    private void readFile() {
        WriteAndReadThreads thread= new WriteAndReadThreads();
        thread.registerObserver(this);
        thread.readFile();
        thread.start();
    }
}