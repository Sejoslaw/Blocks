package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.world.World;

public class BlockEnemy extends BlockMovable
{
	protected static final Color color = Color.RED;
	
	public BlockEnemy(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	public BlockEnemy(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
	
	@Override
	public boolean isPlayer() 
	{
		return false;
	}
}
