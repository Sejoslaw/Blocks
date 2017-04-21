package main.java.kd.movingblocks.event;

import main.java.kd.movingblocks.MovingBlocks;

/**
 * Event used for closing the game.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventCloseGame extends Event 
{
	public void doAction() 
	{
		MovingBlocks.INSTANCE.close();
	}
}