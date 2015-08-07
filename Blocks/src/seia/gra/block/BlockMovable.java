package seia.gra.block;

import java.awt.Color;

import seia.gra.MainClass;
import seia.gra.world.World;

public class BlockMovable extends Block
{
	private static final long serialVersionUID = 1L;

	public BlockMovable(Color c, int x, int y) 
	{
		super(c, x, y);
	}
	
	public boolean moveUpPlayer(BlockPlayer player, World world)
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(world.world[X][Y - 1].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X][Y - 1].getColor() == player.getColor())
			{
				can = false;
			}
			if(can)
			{
				Y--;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveUpEnemy(BlockEnemy enemy, World world)
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(world.world[X][Y - 1].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X][Y - 1].getColor() == enemy.getColor())
			{
				can = false;
			}
			if(can)
			{
				Y--;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveDownPlayer(BlockPlayer player, World world)
	{
		if(Y + 1 < MainClass.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(world.world[X][Y + 1].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X][Y + 1].getColor() == player.getColor())
			{
				can = false;
			}
			if(can)
			{
				Y++;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveDownEnemy(BlockEnemy enemy, World world)
	{
		if(Y + 1 < MainClass.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(world.world[X][Y + 1].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X][Y + 1].getColor() == enemy.getColor())
			{
				can = false;
			}
			if(can)
			{
				Y++;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveLeftPlayer(BlockPlayer player, World world)
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(world.world[X - 1][Y].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X - 1][Y].getColor() == player.getColor())
			{
				can = false;
			}
			if(can)
			{
				X--;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveLeftEnemy(BlockEnemy enemy, World world)
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(world.world[X - 1][Y].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X - 1][Y].getColor() == enemy.getColor())
			{
				can = false;
			}
			if(can)
			{
				X--;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveRightPlayer(BlockPlayer player, World world)
	{
		if(X + 1 < MainClass.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(world.world[X + 1][Y].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X + 1][Y].getColor() == player.getColor())
			{
				can = false;
			}
			if(can)
			{
				X++;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveRightEnemy(BlockEnemy enemy, World world)
	{
		if(X + 1 < MainClass.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(world.world[X + 1][Y].getColor() == Color.BLACK)
			{
				can = false;
			}
			if(world.world[X + 1][Y].getColor() == enemy.getColor())
			{
				can = false;
			}
			if(can)
			{
				X++;
				return true;
			}
		}
		return false;
	}
}
