package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.movable.BlockClonePlayer;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.player.BlockPlayer;

public class EventCheckCollisionWithEnemy extends Event
{
	public static final int CHANCE = 40;
	
	private static void action(MainClass mc)
	{
		mc.newGame();
	}
	
	public static boolean canPlayerMoveUp(MainClass mc)
	{
		BlockPlayer player = mc.worldObj.player;
		for(int i = 0; i < mc.worldObj.currentTiles.size(); i++)
		{
			if(mc.worldObj.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.worldObj.currentTiles.get(i);
				if((player.X == enemy.X) && (player.Y - 1 == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
				if((player.X == enemy.X) && (player.Y - 2 == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
			}
		}
		if(mc.worldObj.isPlaceToAddEnemy())
		{
			mc.worldObj.addEnemy();
		}
		return true;
	}
	
	public static boolean canPlayerMoveDown(MainClass mc)
	{
		BlockPlayer player = mc.worldObj.player;
		for(int i = 0; i < mc.worldObj.currentTiles.size(); i++)
		{
			if(mc.worldObj.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.worldObj.currentTiles.get(i);
				if((player.X == enemy.X) && (player.Y + 1 == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
				if((player.X == enemy.X) && (player.Y + 2 == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
			}
		}
		if(mc.worldObj.isPlaceToAddEnemy())
		{
			mc.worldObj.addEnemy();
		}
		return true;
	}
	
	public static boolean canPlayerMoveLeft(MainClass mc)
	{
		BlockPlayer player = mc.worldObj.player;
		for(int i = 0; i < mc.worldObj.currentTiles.size(); i++)
		{
			if(mc.worldObj.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.worldObj.currentTiles.get(i);
				if((player.X - 1 == enemy.X) && (player.Y == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
				if((player.X - 2 == enemy.X) && (player.Y == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
			}
		}
		if(mc.worldObj.isPlaceToAddEnemy())
		{
			mc.worldObj.addEnemy();
		}
		return true;
	}
	
	public static boolean canPlayerMoveRight(MainClass mc)
	{
		BlockPlayer player = mc.worldObj.player;
		for(int i = 0; i < mc.worldObj.currentTiles.size(); i++)
		{
			if(mc.worldObj.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.worldObj.currentTiles.get(i);
				if((player.X + 1 == enemy.X) && (player.Y == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
				if((player.X + 2 == enemy.X) && (player.Y == enemy.Y))
				{
					if(!EventCanHit.checkIfCanHit(mc))
					{
						action(mc);
						return false;
					}
					else
					{
						if(enemy instanceof BlockClonePlayer)
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit(Event.getPoints(-1, CHANCE));
						}
						else
						{
							mc.worldObj.killEnemy(enemy);
							mc.worldObj.decreaseAfterHit();
						}
					}
				}
			}
		}
		if(mc.worldObj.isPlaceToAddEnemy())
		{
			mc.worldObj.addEnemy();
		}
		return true;
	}
}