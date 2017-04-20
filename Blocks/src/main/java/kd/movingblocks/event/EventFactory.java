package main.java.kd.movingblocks.event;

import java.util.ArrayList;
import java.util.List;

/**
 * This factory will handle all incoming Events.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventFactory
{
	public static final EventFactory INSTANCE = new EventFactory();
	
	/**
	 * Events to be handle.
	 */
	private List<Event> _eventsToHandle = new ArrayList<>();
	
	private EventFactory()
	{
	}
	
	/**
	 * Add Event to the list to be handle.
	 * 
	 * @param e
	 */
	public void postEvent(Event e)
	{
		this._eventsToHandle.add(e);
	}
	
	/**
	 * Process currently collected Events.
	 */
	public void processEvents() 
	{
		for (int i = 0; i < this._eventsToHandle.size(); ++i)
		{
			this._eventsToHandle.get(i).doAction();
			this._eventsToHandle.remove(i);
		}
	}
}