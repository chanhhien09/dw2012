package com.example.projectstyle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapLoadHelper {
	Bitmap enemyBitmap;
	Bitmap bulletBitmap;
	
	public BitmapLoadHelper(Context context)
	{
		enemyBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.droid);
		bulletBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);
		
	}
	
	public Bitmap getEnemyTexture()
	{
		return enemyBitmap;
	}
}
