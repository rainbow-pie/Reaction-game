package com.example.laboratorywork2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Spinner gridSizeSpinner;
    private Spinner timerSpinner;
    private Spinner frameRateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gridSizeSpinner = findViewById(R.id.gridSizeSpinner);
        fillSpinner(gridSizeSpinner, Utility.gridSizes);
        timerSpinner = findViewById(R.id.timerSpinner);
        fillSpinner(timerSpinner, Utility.timers);
        frameRateSpinner = findViewById(R.id.frameRateSpinner);
        fillSpinner(frameRateSpinner, Utility.frameRates);

        findViewById(R.id.go_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra(GameActivity.ARG_PARAM1, (String) gridSizeSpinner.getSelectedItem());
                intent.putExtra(GameActivity.ARG_PARAM2, (String) timerSpinner.getSelectedItem());
                intent.putExtra(GameActivity.ARG_PARAM3, (String) frameRateSpinner.getSelectedItem());
                startActivity(intent);
            }
        });

        findViewById(R.id.records_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecordsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fillSpinner(Spinner spinner, Map map) {
        map.keySet();
        ArrayAdapter<String> adapter = new ArrayAdapter(spinner.getContext(), android.R.layout.simple_spinner_item, map.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}