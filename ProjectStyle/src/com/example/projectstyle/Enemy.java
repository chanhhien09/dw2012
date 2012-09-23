package com.example.projectstyle;

import com.example.projectstyle.AIActionManager.AIActionType;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Enemy implements Animation {
	public boolean alive;
	private Bitmap enemyBitmap;
	private AIAction aiAction;
	public int x;
	public int y;

	public Enemy(Bitmap bitmap, Point startingPoint,
			AIActionManager.AIActionType type) {
		enemyBitmap = bitmap;
		aiAction = AIActionManager.LoadAIActionFromType(this, type);
		this.x = startingPoint.x;
		this.y = startingPoint.y;
		alive = true;
	}

	public void OnUpdate() {
		if (alive)
			aiAction.doAction();
	}

	public void OnDraw(Canvas canvas) {
		if (alive)
			canvas.drawBitmap(enemyBitmap, x, y, null);
	}
}
