package seia.gra.block;

import java.awt.Color;

import seia.gra.world.World;

public class BlockMovable extends Block
{
	private static final long serialVersionUID = 1L;

	public BlockMovable(Color c, int x, int y) 
	{
		super(c, x, y);
	}
	
	public boolean moveUp(World world)
	{
		if((world.world[X][Y - 1].getColor() != Color.BLACK) && (world.world[X][Y - 1].getColor() != world.world[X][Y].getColor()))
		{
			Y--;
			return true;
		}
		return false;
	}
	
	public boolean moveDown(World world)
	{
		if((world.world[X][Y + 1].getColor() != Color.BLACK) && (world.world[X][Y + 1].getColor() != world.world[X][Y].getColor()))
		{
			Y++;
			return true;
		}
		return false;
	}
	
	public boolean moveLeft(World world)
	{
		if((world.world[X - 1][Y].getColor() != Color.BLACK) && (world.world[X - 1][Y].getColor() != world.world[X][Y].getColor()))
		{
			X--;
			return true;
		}
		return false;
	}
	
	public boolean moveRight(World world)
	{
		if((world.world[X + 1][Y].getColor() != Color.BLACK) && (world.world[X + 1][Y].getColor() != world.world[X][Y].getColor()))
		{
			X++;
			return true;
		}
		return false;
	}
}
