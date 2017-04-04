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
	 * Renders this Entity.
	 */
	public abstract void renderEntity(Graphics g);
}