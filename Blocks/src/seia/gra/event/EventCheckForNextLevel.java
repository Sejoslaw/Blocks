package seia.gra.event;

import seia.gra.world.World;

public class EventCheckForNextLevel extends Event
{
	public static boolean check(World world) 
	{
		if(world.player.Y == world.nextLevel.Y)
		{
			if(world.player.X + 1 == world.nextLevel.X)
			{
				world.reloadPanel();
				world.updateLevelValue();
			}
		}
		return false;
	}
}
