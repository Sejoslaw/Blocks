package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.world.World;

public class BlockEnemy extends BlockMovable
{
	private static Color color = Color.RED;
	
	public BlockEnemy(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
}
