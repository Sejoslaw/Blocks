package seia.gra.api.event;

import java.util.Random;

import seia.gra.api.world.WorldRegistry;

public class Event 
{
	protected static WorldRegistry registry = WorldRegistry.INSTANCE;
	
	/**
	 * @param points - ile mozna dodac punktow
	 * @param percent - szansa z jaka dodane zostana punkty
	 * @return - koncowa liczba punktow
	 */
	public static int getPoints(int points, int percent)
	{
		int los = 0;
		int rand = new Random().nextInt(100);
		if(rand > (100 - percent))
			los = points;
		return los;
	}
}
