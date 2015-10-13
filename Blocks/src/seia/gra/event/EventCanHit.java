package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.api.event.Event;
import seia.gra.world.worldelement.WorldElementAvailableHits;

public class EventCanHit extends Event
{
	public static boolean checkIfCanHit(MainClass mc)
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				return ((WorldElementAvailableHits)registry.getWorldElements().get(i)).availableHits > 0;
			}
		}
		return false;
	}
}
