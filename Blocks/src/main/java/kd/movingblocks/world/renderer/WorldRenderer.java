package main.java.kd.movingblocks.world.renderer;

import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.util.BlockPos;
import main.java.kd.movingblocks.world.DimensionManager;
import main.java.kd.movingblocks.world.World;

/**
 * Renderer of the World. (Holds data about painting.)
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public abstract class WorldRenderer 
{
	/**
	 * Dimension id of the World connected with this renderer.
	 */
	private final int _dimId;
	/**
	 * World connected with this Renderer.
	 */
	private World _world;
	
	public WorldRenderer(int dimId)
	{
		this._dimId = dimId;
	}
	
	/**
	 * @return Returns the dimension id of the World connected with this renderer.
	 */
	public int getDimensionId()
	{
		return this._dimId;
	}
	
	/**
	 * @return Returns World of this renderer.
	 */
	public World getWorld()
	{
		if (this._world == null)
		{
			this._world = DimensionManager.getWorldByDimId(_dimId);
		}
		return this._world;
	}
	
	/**
	 * @param pos
	 * 
	 * @return Returns the start point of the block quad 
	 * (top-left point from which we should start drawing this block).
	 */
	protected Point countStartRenderPos(BlockPos pos)
	{
		return new Point(pos.getX() * Settings.BLOCK_WIDTH, pos.getY() * Settings.BLOCK_HEIGHT);
	}

	/**
	 * Paint World.
	 * 
	 * @param g
	 */
	public abstract void renderWorld(Graphics g);
}