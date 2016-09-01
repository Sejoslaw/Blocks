package seia.gra.event;

import java.util.Random;

public class Event 
{
	/**
	 * @param points - how many points can be added
	 * @param percent - chance with which the points will be added
	 * @return - end number of points
	 */
	public static int getPoints(int points, int percent)
	{
		int los = 0;
		int rand = new Random().nextInt(100);
		if(rand > (100 - percent))
		{
			los = points;
		}
		return los;
	}
}