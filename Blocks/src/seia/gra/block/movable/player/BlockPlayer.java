package seia.gra.block.movable.player;

import java.awt.Color;

import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public class BlockPlayer extends BlockMovable
{
	private static Color color = Color.GREEN;
	public InventoryPlayer inventory;
	
	public BlockPlayer(int x, int y, World world) 
	{
		super(color, x, y, world);
		inventory = new InventoryPlayer(this);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
	
	@Override
	public boolean isPlayer() 
	{
		return true;
	}
}
