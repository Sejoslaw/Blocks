package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.movable.BlockPlayer;
import seia.gra.block.nonmovable.BlockNextLevel;

public class EventCheckForNextLevel extends Event
{
	public static boolean check(MainClass mc) 
	{
		BlockPlayer player = mc.player;
		BlockNextLevel nextLevel = mc.nextLevel;
		if(player.Y == nextLevel.Y)
		{
			if(player.X + 1 == nextLevel.X)
			{
				
			}
		}
		return false;
	}
}
