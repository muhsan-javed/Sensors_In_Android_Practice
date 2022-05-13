package com.muhsanapps.sensorsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muhsanapps.sensorsinandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAccelerometer.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Accelerometer.class);
            startActivity(intent);
        });

        binding.btnProximitySensor.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProximitySensor.class);
            startActivity(intent);
        });
        binding.btnLightSensor.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LightSensor.class);
            startActivity(intent);
        });

    }
}