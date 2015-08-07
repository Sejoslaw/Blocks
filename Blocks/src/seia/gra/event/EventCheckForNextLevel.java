package seia.gra.event;

import seia.gra.MainClass;

public class EventCheckForNextLevel extends Event
{
	public static boolean check(MainClass mc) 
	{
		if(mc.player.Y == mc.nextLevel.Y)
		{
			if(mc.player.X + 1 == mc.nextLevel.X)
			{
				mc.reloadPanel();
				mc.updateLevelValue();
			}
		}
		return false;
	}
}
