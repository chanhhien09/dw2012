package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Enemy {
	private Bitmap enemyBitmap;
	private int x;
	private int y;
	
	public Enemy(Bitmap bitmap, int x, int y)
	{
		enemyBitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public void OnUpdate()
	{
		//DO NOthing for now
	}
	
	public void OnDraw(Canvas canvas)
	{
		Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
		canvas.drawBitmap(enemyBitmap, x, y, paint);
	}
	

}
