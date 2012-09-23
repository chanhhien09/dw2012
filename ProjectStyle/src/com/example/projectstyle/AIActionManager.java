package com.example.projectstyle;

public class AIActionManager {
	public enum AIActionType
	{
		RANDOM,
		HORIZONTAL,
		VERTICAL
	}
	
	public AIActionManager()
	{
		
	}
	
	public static EnemyAIAction LoadAIActionFromType(Enemy enemy, AIActionType type)
	{
		switch (type)
		{
		case RANDOM:
			return new RandomAction(enemy);
		case HORIZONTAL:
			return new HorizontalAction(enemy);
		case VERTICAL:
			return new VerticalAction(enemy);
		default:
			return null;
		}
	}
	

}
