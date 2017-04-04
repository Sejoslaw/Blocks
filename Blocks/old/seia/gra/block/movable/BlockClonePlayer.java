package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.block.Block;
import seia.gra.world.World;

public class BlockClonePlayer extends BlockEnemy
{
	public BlockClonePlayer(Color c, int x, int y, World world) 
	{
		super(Block.getPlayerColor(), x, y, world);
	}
	
	public Color getColor()
	{
		return Block.getPlayerColor();
	}
	
	public boolean isPlayer() 
	{
		return false;
	}
	
	public boolean isPlayerClone()
	{
		return true;
	}
}