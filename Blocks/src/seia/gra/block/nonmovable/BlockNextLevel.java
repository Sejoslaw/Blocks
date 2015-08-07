package seia.gra.block.nonmovable;

import java.awt.Color;

public class BlockNextLevel extends BlockNonMovable
{
	private static Color color = Color.YELLOW;
	
	public BlockNextLevel(int x, int y) 
	{
		super(color, x, y);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
}
