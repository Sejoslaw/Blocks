package seia.gra.block.background;

import java.awt.Color;

import seia.gra.world.World;

public class BlockWall extends BlockBackground
{
	protected static final Color color = Color.BLACK;
	
	public BlockWall(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	public BlockWall(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	public boolean canWalkThrough()
	{
		return false;
	}
	
}
