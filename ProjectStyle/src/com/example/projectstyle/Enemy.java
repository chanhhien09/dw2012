package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Enemy {
	private Bitmap enemyBitmap;
	private EnemyAIAction aiAction;
	public int x;
	public int y;
	
	public Enemy(Bitmap bitmap, Point startingPoint, AIActionManager.AIActionType type)
	{
		enemyBitmap = bitmap;
		aiAction = AIActionManager.LoadAIActionFromType(this, type);
		this.x = startingPoint.x;
		this.y = startingPoint.y;
	}

	public void OnUpdate()
	{
		aiAction.doAction();
	}
	
	public void OnDraw(Canvas canvas)
	{
		Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
		canvas.drawBitmap(enemyBitmap, x, y, paint);
	}
}
