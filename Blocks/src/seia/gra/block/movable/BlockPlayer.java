package seia.gra.block.movable;

import java.awt.Color;

public class BlockPlayer extends BlockMovable
{
	private static Color color = Color.GREEN;
	
	public BlockPlayer(int x, int y) 
	{
		super(color, x, y);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
}
