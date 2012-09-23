package com.example.projectstyle;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class Accelerometer implements SensorEventListener {
	public Sensor sensor;

	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	public void onSensorChanged(SensorEvent event) {
		sensor = event.sensor;
	}
}
