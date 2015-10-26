package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.api.block.IBlockMovable;
import seia.gra.block.Block;
import seia.gra.world.World;

public class BlockMovable extends Block implements IBlockMovable
{
	public BlockMovable(Color c, int x, int y, World world) 
	{
		super(c, x, y, world);
	}
	
	public boolean movePlayerUp()
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnTop().getColor() == Color.BLACK) 
				can = false;
			if(can)
			{
				Y--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Zakladamy, ze wiemy, ze to jest przeciwnik.
	 * @return
	 */
	public boolean moveEnemyUp()
	{
		if(Y - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnTop().getColor() == Color.BLACK) 
				can = false;
			if(hasMovable(X, Y - 1)) 
				can = false;
			if(can)
			{
				Y--;
				return true;
			}
		}
		return false;
	}
	
	public boolean movePlayerDown()
	{
		if(Y + 1 < worldObj.mcInstance.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockUnder().getColor() == Color.BLACK)
				can = false;
			if(can)
			{
				Y++;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveEnemyDown()
	{
		if(Y + 1 < worldObj.mcInstance.getHeightInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockUnder().getColor() == Color.BLACK)
				can = false;
			if(hasMovable(X, Y + 1))
				can = false;
			if(can)
			{
				Y++;
				return true;
			}
		}
		return false;
	}
	
	public boolean movePlayerLeft()
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnLeft().getColor() == Color.BLACK)
				can = false;
			if(can)
			{
				X--;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveEnemyLeft()
	{
		if(X - 1 > 0)
		{
			boolean can = true;
			if(getBlockOnLeft().getColor() == Color.BLACK)
				can = false;
			if(hasMovable(X - 1, Y))
				can = false;
			if(can)
			{
				X--;
				return true;
			}
		}
		return false;
	}
	
	public boolean movePlayerRight()
	{
		if(X + 1 < worldObj.mcInstance.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockOnRight().getColor() == Color.BLACK)
				can = false;
			if(can)
			{
				X++;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveEnemyRight()
	{
		if(X + 1 < worldObj.mcInstance.getWidthInBlocks() - 1)
		{
			boolean can = true;
			if(getBlockOnRight().getColor() == Color.BLACK)
				can = false;
			if(hasMovable(X + 1, Y))
				can = false;
			if(can)
			{
				X++;
				return true;
			}
		}
		return false;
	}
}
