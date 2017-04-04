package seia.gra.block.movable.player;

import java.awt.Color;

import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public class BlockPlayer extends BlockMovable
{
	private static Color COLOR = Color.GREEN;
	
	public InventoryPlayer inventory;
	
	public BlockPlayer(int x, int y, World world) 
	{
		super(COLOR, x, y, world);
		inventory = new InventoryPlayer(this);
	}
	
	public BlockPlayer(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
		inventory = new InventoryPlayer(this);
	}
	
	public Color getColor()
	{
		return COLOR;
	}
	
	public boolean isPlayer() 
	{
		return true;
	}
}