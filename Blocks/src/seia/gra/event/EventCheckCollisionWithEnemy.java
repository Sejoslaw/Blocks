package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.player.BlockPlayer;

public class EventCheckCollisionWithEnemy extends Event
{
	private static void action(MainClass mc)
	{
		mc.newGame();
	}
	
	public static boolean canPlayerMoveUp(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.enemy.size(); i++)
		{
			BlockEnemy enemy = mc.world.enemy.get(i);
			if((player.X == enemy.X) && (player.Y - 1 == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
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
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveDown(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.enemy.size(); i++)
		{
			BlockEnemy enemy = mc.world.enemy.get(i);
			if((player.X == enemy.X) && (player.Y + 1 == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
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
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveLeft(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.enemy.size(); i++)
		{
			BlockEnemy enemy = mc.world.enemy.get(i);
			if((player.X - 1 == enemy.X) && (player.Y == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
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
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveRight(MainClass mc)
	{
		BlockPlayer player = mc.world.player;
		for(int i = 0; i < mc.world.enemy.size(); i++)
		{
			BlockEnemy enemy = mc.world.enemy.get(i);
			if((player.X + 1 == enemy.X) && (player.Y == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
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
					mc.world.killEnemy(enemy);
					mc.world.decreaseAfterHit();
				}
			}
		}
		return true;
	}
}
