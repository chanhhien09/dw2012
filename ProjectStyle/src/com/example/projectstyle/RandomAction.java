package com.example.projectstyle;

public class RandomAction implements AIAction {
	private final int MAX_HORIZONTAL_DISTANCE = 400;
	private final int MAX_VERTICAL_DISTANCE = 800;
	private final int MIN_DISTANCE = 0;
	private Enemy enemy;
	private int factor;
	public RandomAction(Enemy e)
	{
		enemy = e;
	}
	
	public void doAction()
	{
		int speed = factor * (int)(Math.random()*30);
		
		if (speed % 2 == 0)
		{
			if (enemy.x > MAX_HORIZONTAL_DISTANCE)
				enemy.x = MAX_HORIZONTAL_DISTANCE;
			else if (enemy.x < MIN_DISTANCE)
				enemy.x = MIN_DISTANCE;
			else
				enemy.x = enemy.x + speed;
			factor = -1;
		}
		else
		{
			if (enemy.y > MAX_VERTICAL_DISTANCE)
				enemy.y = MAX_VERTICAL_DISTANCE;
			else if (enemy.y < MIN_DISTANCE)
				enemy.y = MIN_DISTANCE;
			else
				enemy.y = enemy.y + speed;
			factor = 1;
		}
	}
}
