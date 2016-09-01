package seia.gra.block.nonmovable;

import java.awt.Color;

import seia.gra.world.World;

public class BlockNextLevel extends BlockNonMovable
{
	private static Color color = Color.YELLOW;
	
	public BlockNextLevel(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	public Color getColor()
	{
		return color;
	}
}