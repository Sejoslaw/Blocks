package main.java.kd.movingblocks.event.move;

import main.java.kd.movingblocks.entity.Entity;

/**
 * Entity which should be post to move an Entity LEFT.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventMoveEntityLEFT extends EventMoveEntity 
{
	public EventMoveEntityLEFT(int keyCode, Entity entity) 
	{
		super(keyCode, entity);
	}
	
	public void doAction() 
	{
		if (getEntity().getX() > 1)
			getEntity().moveLeft();
	}
}