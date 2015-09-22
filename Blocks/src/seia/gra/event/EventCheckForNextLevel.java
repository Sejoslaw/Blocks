package seia.gra.event;

import java.util.Random;

import seia.gra.world.World;

public class EventCheckForNextLevel extends Event
{
	public static boolean check(World world)
	{
		if(world.player.Y == world.getNextLevel().Y)
		{
			if(world.player.X + 1 == world.getNextLevel().X)
			{
				world.reloadPanel();
				world.updateLevelValue();
				world.addAvaiableHits(getHits(1, 30));
			}
		}
		return false;
	}

	/**
	 * @param points - ile mozna dodac punktow ataku
	 * @param percent - szansa z jaka dodane zostana punkty
	 * @return - ile punktow doda
	 */
	public static int getHits(int points, int percent)
	{
		int los = 0;
		int rand = new Random().nextInt(100);
		if(rand > (100 - percent))
			los = points;
		return los;
	}
}
