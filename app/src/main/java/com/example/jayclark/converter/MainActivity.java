package com.example.jayclark.converter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button distanceButton = (Button) findViewById(R.id.distance);

        distanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDistanceActivity();
            }
        });

        Button temperatureButton = (Button) findViewById(R.id.temperature);
        temperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTemperatureActivity();
            }
        });
        Button weightButton = (Button) findViewById(R.id.weight);
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeightActivity();
            }
        });
        Button volumeButton = (Button) findViewById(R.id.volume);
        volumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVolumeActivity();
            }
        });
    }

    public void openDistanceActivity() {
        Intent intent = new Intent(this, Distance.class);
        startActivity(intent);
    }
    public void openTemperatureActivity() {
        Intent intent = new Intent(this, Temperature.class);
        startActivity(intent);
    }
    public void openWeightActivity() {
        Intent intent = new Intent(this, Weight.class);
        startActivity(intent);
    }
    public void openVolumeActivity() {
        Intent intent = new Intent(this, Volume.class);
        startActivity(intent);
    }
}
