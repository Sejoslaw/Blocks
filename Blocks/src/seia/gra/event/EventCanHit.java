package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.world.worldelement.WorldElementAvailableHits;

public class EventCanHit extends Event
{
	public static boolean checkIfCanHit(MainClass mc)
	{
		for(int i = 0; i < mc.world.worldElement.size(); i++)
		{
			if(mc.world.worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				return ((WorldElementAvailableHits)mc.world.worldElement.get(i)).availableHits > 0;
			}
		}
		return false;
	}
}
