package com.example.projectstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class MainGamePanel extends View {
	private Enemy droid;
	
	public MainGamePanel(Context context){
		super(context);
		BitmapLoadHelper bitmapHelper = new BitmapLoadHelper(context);	
		droid = new Enemy(bitmapHelper.getEnemyTexture(), new Point(50, 50), AIActionManager.AIActionType.HORIZONTAL);
		setFocusable(true);
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		//TO DO
		return super.onTouchEvent(event);
	}
	
	public void update() {
		droid.OnUpdate();
	}
	
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		//canvas.drawColor(Color.BLACK);
		droid.OnDraw(canvas);
	}
	
	protected void render(Canvas canvas)
	{
		onDraw(canvas);
	}
}
