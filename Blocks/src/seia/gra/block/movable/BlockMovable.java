package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.MainClass;
import seia.gra.block.Block;
import seia.gra.world.World;

public class BlockMovable extends Block
{
	public BlockMovable(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	public boolean moveUpPlayer(World world)
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnTop(world).getColor() == Color.BLACK)
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
	
	public boolean moveUpEnemy(World world)
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnTop(world).getColor() == Color.BLACK)
			{
				can = false;
			}
			for(int i = 0; i < world.enemy.size(); i++)
			{
				if((Y - 1 == world.enemy.get(i).Y) && (X == world.enemy.get(i).X))
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
	
	public boolean moveDownPlayer(World world)
	{
		if(Y + 1 < MainClass.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockUnder(world).getColor() == Color.BLACK)
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
	
	public boolean moveDownEnemy(World world)
	{
		if(Y + 1 < MainClass.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockUnder(world).getColor() == Color.BLACK)
			{
				can = false;
			}
			for(int i = 0; i < world.enemy.size(); i++)
			{
				if((Y + 1 == world.enemy.get(i).Y) && (X == world.enemy.get(i).X))
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
	
	public boolean moveLeftPlayer(World world)
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnLeft(world).getColor() == Color.BLACK)
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
	
	public boolean moveLeftEnemy(World world)
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnLeft(world).getColor() == Color.BLACK)
			{
				can = false;
			}
			for(int i = 0; i < world.enemy.size(); i++)
			{
				if((Y == world.enemy.get(i).Y) && (X - 1 == world.enemy.get(i).X))
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
	
	public boolean moveRightPlayer(World world)
	{
		if(X + 1 < MainClass.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockOnRight(world).getColor() == Color.BLACK)
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
	
	public boolean moveRightEnemy(World world)
	{
		if(X + 1 < MainClass.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockOnRight(world).getColor() == Color.BLACK)
			{
				can = false;
			}
			for(int i = 0; i < world.enemy.size(); i++)
			{
				if((Y == world.enemy.get(i).Y) && (X + 1 == world.enemy.get(i).X))
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
