package main.java.kd.movingblocks.event.move;

import main.java.kd.movingblocks.entity.Entity;

/**
 * Entity which should be post to move an Entity UP.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventMoveEntityUP extends EventMoveEntity 
{
	public EventMoveEntityUP(int keyCode, Entity entity) 
	{
		super(keyCode, entity);
	}

	public void doAction() 
	{
		if (getEntity().getY() > 1)
			getEntity().moveUp();
	}
}