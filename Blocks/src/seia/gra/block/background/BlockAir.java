package seia.gra.block.background;

import java.awt.Color;

import seia.gra.world.World;

public class BlockAir extends BlockBackground
{
	protected static final Color color = Color.BLUE;
	
	public BlockAir(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	public BlockAir(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	public boolean canWalkThrough()
	{
		return true;
	}
}
