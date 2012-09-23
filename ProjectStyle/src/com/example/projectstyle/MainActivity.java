package com.example.projectstyle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

/*
 public class MainActivity extends Activity implements OnClickListener{


 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);

 setContentView(R.layout.activity_main);

 Button btnCamera = (Button) findViewById(R.id.buttonCamera);
 btnCamera.setOnClickListener(this);

 }


 public void onClick(View v) {
 */

public class MainActivity extends Activity implements OnClickListener {
	private SensorManager sensorManager;
	private Accelerometer accelerometer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		/*
		 * super.onCreate(savedInstanceState);
		 * setContentView(R.layout.activity_main);
		 * 
		 * Button btnCamera = (Button) findViewById(R.id.buttonCamera);
		 * btnCamera.setOnClickListener(this);
		 */
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Context ctx = this.getApplicationContext();
		CustomCameraView cv = new CustomCameraView(ctx);
		LayoutParams layoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		addContentView(cv, layoutParams);
		addContentView(new MainGamePanel(ctx),
				layoutParams);
		
		sensorManager = (SensorManager) getSystemService(ctx.SENSOR_SERVICE);
		accelerometer = new Accelerometer();
		accelerometer.sensor = sensorManager.getDefaultSensor(SensorManager.SENSOR_ACCELEROMETER);
		
		sensorManager.registerListener(accelerometer, accelerometer.sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		sensorManager.unregisterListener(accelerometer);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		sensorManager.registerListener(accelerometer, accelerometer.sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonCamera:
			Intent cameraIntent = new Intent(MainActivity.this,
					CameraActivity.class);
			startActivity(cameraIntent);
			break;
		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
