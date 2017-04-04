package main.java.kd.movingblocks.block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;

/**
 * Single block definition.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class Block 
{
	/**
	 * Unique block id.
	 */
	private final int _id;
	/**
	 * Unique block color.
	 */
	private final Color _color;
	
	public Block(int id, Color color)
	{
		this._id = id;
		this._color = color;
		Blocks.BLOCKS.add(this);
	}
	
	/**
	 * @return Returns block id.
	 */
	public int getBlockId()
	{
		return this._id;
	}
	
	/**
	 * @return Returns block color.
	 */
	public Color getBlockColor()
	{
		return this._color;
	}

	/**
	 * Render this block.
	 * 
	 * @param g
	 * @param startPos Top-left start point
	 */
	public void renderBlock(Graphics g, Point startPos) 
	{
		g.setColor(this._color);
		g.fillRect(
				startPos.x,
				startPos.y,
				Settings.BLOCK_WIDTH, 
				Settings.BLOCK_HEIGHT);
		
		// Debug
		g.setColor(Color.RED);
		g.drawRect(
				startPos.x,
				startPos.y,
				Settings.BLOCK_WIDTH, 
				Settings.BLOCK_HEIGHT);
	}
}