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
	
	public boolean moveUp(Block block, World world)
	{
		if(block instanceof BlockPlayer)
		{
			if(Y - 1 > 0)
			{
				boolean can = true;
				if(((BlockPlayer)world.world[X][Y - 1]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockPlayer)world.world[X][Y - 1]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					Y--;
					return true;
				}
			}
		}
		if(block instanceof BlockEnemy)
		{
			if(Y - 1 > 0)
			{
				boolean can = true;
				if(((BlockEnemy)world.world[X][Y - 1]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockEnemy)world.world[X][Y - 1]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					Y--;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moveDown(Block block, World world)
	{
		if(block instanceof BlockPlayer)
		{
			if(Y + 1 < MainClass.getHeightInBlocks())
			{
				boolean can = true;
				if(((BlockPlayer)world.world[X][Y + 1]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockPlayer)world.world[X][Y + 1]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					Y++;
					return true;
				}
			}
		}
		if(block instanceof BlockEnemy)
		{
			if(Y + 1 < MainClass.getHeightInBlocks())
			{
				boolean can = true;
				if(((BlockEnemy)world.world[X][Y + 1]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockEnemy)world.world[X][Y + 1]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					Y++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moveLeft(Block block, World world)
	{
		if(block instanceof BlockPlayer)
		{
			if(X - 1 > 0)
			{
				boolean can = true;
				if(((BlockPlayer)world.world[X - 1][Y]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockPlayer)world.world[X - 1][Y]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					X--;
					return true;
				}
			}
		}
		if(block instanceof BlockEnemy)
		{
			if(X - 1 > 0)
			{
				boolean can = true;
				if(((BlockEnemy)world.world[X - 1][Y]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockEnemy)world.world[X - 1][Y]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					X--;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moveRight(Block block, World world)
	{
		if(block instanceof BlockPlayer)
		{
			if(X + 1 < MainClass.getWidthInBlocks())
			{
				boolean can = true;
				if(((BlockPlayer)world.world[X + 1][Y]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockPlayer)world.world[X + 1][Y]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					X++;
					return true;
				}
			}
		}
		if(block instanceof BlockEnemy)
		{
			if(X + 1 < MainClass.getWidthInBlocks())
			{
				boolean can = true;
				if(((BlockEnemy)world.world[X + 1][Y]).getColor() == Color.BLACK)
				{
					can = false;
				}
				if(((BlockEnemy)world.world[X + 1][Y]).getColor() == world.world[X][Y].getColor())
				{
					can = false;
				}
				if(can)
				{
					X++;
					return true;
				}
			}
		}
		return false;
	}
}
