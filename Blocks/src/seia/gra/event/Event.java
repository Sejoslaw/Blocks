package seia.gra.event;

import java.util.Random;

public class Event 
{
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
