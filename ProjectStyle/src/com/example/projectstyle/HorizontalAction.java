package com.example.projectstyle;

public class HorizontalAction implements AIAction {
	private final int MAX_DISTANCE = 400;
	private final int MIN_DISTANCE = 0;
	private final float NORMAL_SPEED = .01f;
	private float speed = NORMAL_SPEED;
	
	private Enemy enemy;
	public HorizontalAction(Enemy e)
	{
		enemy = e;
	}
	
	public void doAction()
	{

		enemy.x = enemy.x + speed;
		if (enemy.x > MAX_DISTANCE)
			speed = -NORMAL_SPEED;
		else if (enemy.x < MIN_DISTANCE)
			speed = NORMAL_SPEED;
	}

}
