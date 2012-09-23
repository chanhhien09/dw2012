package com.example.projectstyle;

public class VerticalAction implements AIAction {
	private final int MAX_DISTANCE = 700;
	private final int MIN_DISTANCE = 0;
	private int speed = 10;
	
	private Enemy enemy;
	public VerticalAction(Enemy e)
	{
		enemy = e;
	}
	
	public void doAction()
	{
		
		enemy.y = enemy.y + speed;
		if (enemy.x > MAX_DISTANCE)
			speed = -10;
		else if (enemy.x < MIN_DISTANCE)
			speed = 10;
	}

}
