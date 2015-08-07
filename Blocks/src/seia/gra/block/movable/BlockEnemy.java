package seia.gra.block.movable;

import java.awt.Color;

public class BlockEnemy extends BlockMovable
{
	private static Color color = Color.RED;
	
	public BlockEnemy(int x, int y) 
	{
		super(color, x, y);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
}
