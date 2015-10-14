package seia.gra.block.nonmovable;

import java.awt.Color;

import seia.gra.api.block.BlockNonMovable;
import seia.gra.world.World;

public class BlockWall extends BlockNonMovable
{
	public static final Color color = Color.BLACK;
	
	public BlockWall(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	public BlockWall(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public boolean canWalkThrough()
	{
		return false;
	}
	
}
