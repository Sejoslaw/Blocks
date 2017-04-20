package main.java.kd.movingblocks.util;

import main.java.kd.movingblocks.block.Block;

/**
 * Hold data about single Block on World on single position.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class BlockData 
{
	/**
	 * Position on World
	 */
	private final BlockPos _pos;
	/**
	 * Block on this position
	 */
	private Block _block;
	
	public BlockData(BlockPos pos, Block block)
	{
		this._pos = pos;
		this._block = block;
	}
	
	/**
	 * @return Returns position of this data.
	 */
	public BlockPos getPos()
	{
		return this._pos;
	}
	
	/**
	 * @return Returns Block connected with specified position.
	 */
	public Block getBlock()
	{
		return this._block;
	}
	
	/**
	 * Sets new Block at this position.
	 * 
	 * @param block
	 */
	public void setBlock(Block block)
	{
		this._block = block;
	}
}