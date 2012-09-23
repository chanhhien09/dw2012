package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Bullet implements Animation{
	public boolean alive;
	private Bitmap bulletBitmap;
	private AIAction aiAction;
	public int x;
	public int y;
	
	public Bullet(Bitmap bitmap, Point point, AIActionManager.AIActionType type) {
		bulletBitmap = bitmap;
		aiAction = AIActionManager.LoadAIActionFromType(this, type);
		x = point.x;
		y = point.y;
		alive = true;
	}
	
	public void OnUpdate()
	{
		if (alive)
			aiAction.doAction();
	}
	
	public void OnDraw(Canvas canvas)
	{
		if (alive)
			canvas.drawBitmap(bulletBitmap, x, y, null);
	}
	
}
