package com.muhsanapps.sensorsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        Objects.requireNonNull(getSupportActionBar()).setTitle("back");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {

            Sensor accleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if (accleroSensor != null) {
                sensorManager.registerListener(this, accleroSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }

        } else {
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ((TextView) findViewById(R.id.txtValues)).setText("X: " + sensorEvent.values[0] + "/n Y: " + sensorEvent.values[1] + "/n Z: " + sensorEvent.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}