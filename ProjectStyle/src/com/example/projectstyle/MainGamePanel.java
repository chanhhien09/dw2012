package com.example.projectstyle;

import com.example.projectstyle.AIActionManager.AIActionType;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.SurfaceView;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.MotionEvent;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback{
	private MainThread thread;
	private Enemy droid;
	
	public MainGamePanel(Context context){
		super(context);
		getHolder().addCallback(this);
		BitmapLoadHelper bitmapHelper = new BitmapLoadHelper(context);	
		droid = new Enemy(bitmapHelper.getEnemyTexture(), new Point(50, 50), AIActionManager.AIActionType.HORIZONTAL);
		setFocusable(true);
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	public void surfaceCreated(SurfaceHolder holder)
	{
		thread = new MainThread(getHolder(), this);
		thread.setRunning(true);
		thread.start();
	}
	
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		boolean retry = true;
		while (retry) {
			try {
				thread.setRunning(false);
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
	}
	
	
	public boolean onTouchEvent(MotionEvent event)
	{
		//TO DO
		return super.onTouchEvent(event);
	}
	
	public void update() {
		droid.OnUpdate();
	}
	
	protected void render(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		droid.OnDraw(canvas);
	}
	

}
