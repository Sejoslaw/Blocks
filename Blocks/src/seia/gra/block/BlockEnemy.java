package seia.gra.block;

import java.awt.Color;

public class BlockEnemy extends BlockMovable
{
	public static final long serialVersionUID = 1L;

	public BlockEnemy(int x, int y) 
	{
		super(Color.RED, x, y);
	}
	
	@Override
	public Color getColor()
	{
		return Color.RED;
	}
}
