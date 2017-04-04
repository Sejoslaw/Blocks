package main.java.kd.movingblocks.event;

import java.util.ArrayList;
import java.util.List;

import main.java.kd.movingblocks.MovingBlocks;

/**
 * This factory will handle all incoming Events.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventFactory implements Runnable
{
	public static final EventFactory INSTANCE = new EventFactory();
	
	/**
	 * Thread which runs alongside MovingBlocks.
	 */
	private Thread _factoryThread;
	/**
	 * Events to be handle.
	 */
	private List<Event> _eventsToHandle;
	
	private EventFactory()
	{
		_factoryThread = new Thread(this);
		_factoryThread.start();
		
		_eventsToHandle = new ArrayList<>();
	}
	
	/**
	 * Handles all incoming Events.
	 */
	public void run() 
	{
		while(MovingBlocks.INSTANCE.isRunning())
		{
			try
			{
				if(this._eventsToHandle.size() > 0)
					this._eventsToHandle.get(0).doAction();
			}
			finally
			{
			}
		}
	}
	
	/**
	 * Add Event to the list to be handle.
	 * 
	 * @param e
	 */
	public synchronized void postEvent(Event e)
	{
		this._eventsToHandle.add(e);
	}
}