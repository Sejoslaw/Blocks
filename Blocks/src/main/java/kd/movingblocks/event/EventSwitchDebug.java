package main.java.kd.movingblocks.event;

import main.java.kd.movingblocks.Settings;

/**
 * Event which is fired when Debug Key was pressed.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see {@link Settings.Debug#KEY_DEBUG}
 */
public class EventSwitchDebug extends Event 
{
	public void doAction() 
	{
		if(Settings.Debug.SHOW_DEBUG == false)
			Settings.Debug.SHOW_DEBUG = true;
		else
			Settings.Debug.SHOW_DEBUG = false;
	}
}