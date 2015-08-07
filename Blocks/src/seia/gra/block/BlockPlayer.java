package seia.gra.block;

import java.awt.Color;

public class BlockPlayer extends BlockMovable
{
	private static final long serialVersionUID = 1L;

	public BlockPlayer(int x, int y) 
	{
		super(Color.GREEN, x, y);
	}
	
	@Override
	public Color getColor()
	{
		return Color.GREEN;
	}
}
