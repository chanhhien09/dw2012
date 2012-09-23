package com.example.projectstyle;

import com.example.projectstyle.AIActionManager.AIActionType;

import android.graphics.Bitmap;
import android.graphics.Canvas;
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
		canvas.drawBitmap(enemyBitmap, x, y, null);
	}
}
