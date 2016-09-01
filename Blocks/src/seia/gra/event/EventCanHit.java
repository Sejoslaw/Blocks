package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.world.WorldRegistry;
import seia.gra.world.worldelement.WorldElementAvailableHits;

public class EventCanHit extends Event
{
	public static boolean checkIfCanHit(MainClass mc)
	{
		for(int i = 0; i < WorldRegistry.INSTANCE.WORLD_ELEMENTS.size(); i++)
		{
			if(WorldRegistry.INSTANCE.WORLD_ELEMENTS.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				return ((WorldElementAvailableHits)WorldRegistry.INSTANCE.WORLD_ELEMENTS.get(i)).availableHits > 0;
			}
		}
		return false;
	}
}