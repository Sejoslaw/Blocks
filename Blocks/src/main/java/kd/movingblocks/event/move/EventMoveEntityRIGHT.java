package main.java.kd.movingblocks.event.move;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.entity.Entity;

/**
 * Entity which should be post to move an Entity RIGHT.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventMoveEntityRIGHT extends EventMoveEntity 
{
	public EventMoveEntityRIGHT(int keyCode, Entity entity) 
	{
		super(keyCode, entity);
	}
	
	public void doAction() 
	{
		if (getEntity().getX() < Settings.BLOCKS_IN_ROW - 2)
			getEntity().moveRight();
		// Check collision
		super.doAction();
	}
}