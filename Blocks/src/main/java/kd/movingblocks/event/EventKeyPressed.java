package main.java.kd.movingblocks.event;

/**
 * Root of the Event system.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventKeyPressed extends Event
{
	/**
	 * KeyCode of the button to be handle.
	 */
	private final int _keyCode;
	
	public EventKeyPressed(int keyCode)
	{
		this._keyCode = keyCode;
	}
	
	public void doAction() 
	{
	}
}