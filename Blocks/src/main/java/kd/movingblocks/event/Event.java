package main.java.kd.movingblocks.event;

/**
 * Root of the Event system.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public abstract class Event 
{
	/**
	 * This is fired when Event should be handle by {@link EventFactory}.
	 */
	public abstract void doAction();
}