package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Enemy implements Animation {
	public boolean alive;
	private Bitmap enemyBitmap;
	private AIAction aiAction;
	public float x;
	public float y;

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
			canvas.drawBitmap(enemyBitmap, (int) x, (int) y, null);
	}
}
