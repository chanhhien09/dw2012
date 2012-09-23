package com.example.projectstyle;

public class HorizontalAction implements EnemyAIAction {
	private final int MAX_DISTANCE = 400;
	private final int MIN_DISTANCE = 0;
	private int speed = 10;
	
	private Enemy enemy;
	public HorizontalAction(Enemy e)
	{
		enemy = e;
	}
	
	public void doAction()
	{

		enemy.x = enemy.x + speed;
		if (enemy.x > MAX_DISTANCE)
			speed = -10;
		else if (enemy.x < MIN_DISTANCE)
			speed = 10;
	}

}
