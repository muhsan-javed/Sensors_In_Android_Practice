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

public class ProximitySensor extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        getSupportActionBar().setTitle("back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager!=null){
            Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proximitySensor!= null){
                sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY){
            ((TextView)findViewById(R.id.txtValues)).setText("Values: "+ sensorEvent.values[0]);
            
            if (sensorEvent.values[0] > 0){
                Toast.makeText(this, "Object is Far", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Object is Near", Toast.LENGTH_SHORT).show();
            }
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