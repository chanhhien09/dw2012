package com.example.projectstyle;

public class AIActionManager {
	public enum AIActionType
	{
		RANDOM,
		HORIZONTAL,
		VERTICAL,
		BULLET
	}
	
	public AIActionManager()
	{
		
	}
	
	public static AIAction LoadAIActionFromType(Animation animation, AIActionType type)
	{
		switch (type)
		{
		case RANDOM:
			return new RandomAction((Enemy) animation);
		case HORIZONTAL:
			return new HorizontalAction((Enemy) animation);
		case VERTICAL:
			return new VerticalAction((Enemy) animation);
		case BULLET:
			return new BulletAction((Bullet) animation);
		default:
			return null;
		}
	}
	

}
