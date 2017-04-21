package main.java.kd.movingblocks.entity;

import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.world.World;

/**
 * Main Entity class.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public abstract class Entity 
{
	/**
	 * Entity position
	 */
	private int _posX, _posY;
	/**
	 * World on which Entity currently is.
	 */
	private World _world;
	
	/**
	 * Sets the position of this Entity.
	 * 
	 * @param posX
	 * @param posY
	 */
	public void setPosition(int posX, int posY)
	{
		this._posX = posX;
		this._posY = posY;
	}
	
	/**
	 * Sets the World of this Entity.
	 * 
	 * @param world
	 */
	public void setWorld(World world)
	{
		this._world = world;
	}
	
	/**
	 * @return Returns Entity X-position.
	 */
	public int getX()
	{
		return this._posX;
	}
	
	/**
	 * @return Returns Entity Y-position.
	 */
	public int getY()
	{
		return this._posY;
	}
	
	/**
	 * @return Returns the World on which Entity currently is.
	 */
	public World getWorld()
	{
		return this._world;
	}
	
	/**
	 * @return Returns the Top-Left point from which we should start rendering this Entity.
	 * It will be as local (0, 0) to render from.
	 */
	protected Point getTopLeftPointToRender()
	{
		return new Point(getX() * Settings.BLOCK_WIDTH, getY() * Settings.BLOCK_HEIGHT);
	}
	
	/**
	 * Moves this Entity Up.
	 */
	public void moveUp()
	{
		this._posY--;
	}
	
	/**
	 * Moves this Entity Up moves times.
	 */
	public void moveUp(int moves)
	{
		this._posY = this._posY - moves;
	}
	
	/**
	 * Moves this Entity Down.
	 */
	public void moveDown()
	{
		this._posY++;
	}
	
	/**
	 * Moves this Entity Down moves times.
	 */
	public void moveDown(int moves)
	{
		this._posY = this._posY + moves;
	}
	
	/**
	 * Moves this Entity Left.
	 */
	public void moveLeft()
	{
		this._posX--;
	}
	
	/**
	 * Moves this Entity Left moves times.
	 */
	public void moveLeft(int moves)
	{
		this._posX = this._posX - moves;
	}
	
	/**
	 * Moves this Entity Right.
	 */
	public void moveRight()
	{
		this._posX++;
	}
	
	/**
	 * Moves this Entity Right moves times.
	 */
	public void moveRight(int moves)
	{
		this._posX = this._posX + moves;
	}
	
	public String toString()
	{
		return "Entity[X=" + getX() + ", Y=" + getY() + ", " + getWorld().toString() + "]";
	}
	
	/**
	 * @param entity
	 * 
	 * @return Returns TRUE if the given Entity is on the same position on which this Entity is.
	 */
	public boolean isOnTheSamePosition(Entity entity)
	{
		if (this.getX() == entity.getX())
			if (this.getY() == entity.getY())
				return true;
		return false;
	}
	
	/**
	 * Renders this Entity.
	 */
	public abstract void renderEntity(Graphics g);
}