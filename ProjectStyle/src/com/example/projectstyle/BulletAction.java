package com.example.projectstyle;

public class BulletAction implements AIAction {
	private final int MIDDLE_X_POINT = 200;
	private final int MIDDLE_Y_POINT = 400;
	
	private int speed = 20;
	
	private Bullet bullet;
	public BulletAction(Bullet b)
	{
		bullet = b;
	}
	
	public void doAction()
	{

		bullet.x = bullet.x + speed;
		bullet.y = bullet.y + 2*speed;
		
		if (bullet.x > MIDDLE_X_POINT && bullet.y > MIDDLE_Y_POINT)
			bullet.alive = false;
	}
}
