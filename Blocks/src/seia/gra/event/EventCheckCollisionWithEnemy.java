package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.movable.BlockClonePlayer;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.player.BlockPlayer;

public class EventCheckCollisionWithEnemy extends Event
{
	/**
	 * Szansa w procentach z jaka zostana dodane punkty po zjedzeniu klona.
	 */
	public static final int chance = 40;
	
	private static void action(MainClass mc)
	{
		mc.newGame();
	}
	
	public static boolean canPlayerMoveUp(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.currentTiles.size(); i++)
		{
			if(mc.world.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.world.currentTiles.get(i);
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveDown(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.currentTiles.size(); i++)
		{
			if(mc.world.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.world.currentTiles.get(i);
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveLeft(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.currentTiles.size(); i++)
		{
			if(mc.world.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.world.currentTiles.get(i);
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveRight(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.currentTiles.size(); i++)
		{
			if(mc.world.currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) mc.world.currentTiles.get(i);
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
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
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit(Event.getPoints(-1, chance));
						}
						else
						{
							mc.world.killEnemy(enemy);
							mc.world.decreaseAfterHit();
						}
					}
				}
			}
		}
		return true;
	}
}
