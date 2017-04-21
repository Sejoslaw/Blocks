package main.java.kd.movingblocks.event.move;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.entity.Entity;
import main.java.kd.movingblocks.entity.EntityPlayer;
import main.java.kd.movingblocks.event.Event;

/**
 * Root of the Event system.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
 */
public abstract class EventMoveEntity extends Event
{
	/**
	 * KeyCode of the button to be handle.
	 */
	private final int _keyCode;
	/**
	 * Entity which will be moved.
	 */
	private final Entity _entity;
	
	public EventMoveEntity(int keyCode, Entity entity)
	{
		this._keyCode = keyCode;
		this._entity = entity;
	}
	
	/**
	 * @return Returns the pressed key code.
	 */
	public int getKeyCode()
	{
		return this._keyCode;
	}
	
	public Entity getEntity()
	{
		return this._entity;
	}
	
	public void doAction()
	{
		// We only check on Enemy move
		if(getEntity() instanceof EntityPlayer) return;
		
		// Check collision
		if (MovingBlocks.INSTANCE.getPlayer().isOnTheSamePosition(getEntity()))
			MovingBlocks.INSTANCE.getPlayer().hitEnemy(getEntity());
	}
}