package seia.gra.event;

import seia.gra.world.World;

public class EventCheckForNextLevel extends Event
{
	public static boolean check(World world)
	{
		if(world.player.Y == world.getNextLevel().Y)
		{
			if(world.player.X + 1 == world.getNextLevel().X)
			{
				if(world.areAllPlayerGone()) //jezeli wszyscy graczopochodni weszli na nastepny poziom
				{
					world.reloadPanel();
					world.updateLevelValue();
					world.addAvaiableHits(getPoints(1, 0));
				}
				else
				{
					world.killCurrentPlayer();
				}
			}
		}
		return false;
	}
	
}
