package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.BlockPlayer;

public class EventCheckCollisionWithEnemy extends Event
{
	private static void action(MainClass mc)
	{
		mc.newGame();
	}
	
	public static boolean canPlayerMoveUp(MainClass mc)
	{
		BlockPlayer player = mc.player;
		for(int i = 0; i < MainClass.getEnemyList().size(); i++)
		{
			BlockEnemy enemy = MainClass.getEnemyList().get(i);
			if((player.X == enemy.X) && (player.Y - 1 == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
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
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveDown(MainClass mc)
	{
		BlockPlayer player = mc.player;
		for(int i = 0; i < MainClass.getEnemyList().size(); i++)
		{
			BlockEnemy enemy = MainClass.getEnemyList().get(i);
			if((player.X == enemy.X) && (player.Y + 1 == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
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
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveLeft(MainClass mc)
	{
		BlockPlayer player = mc.player;
		for(int i = 0; i < MainClass.getEnemyList().size(); i++)
		{
			BlockEnemy enemy = MainClass.getEnemyList().get(i);
			if((player.X - 1 == enemy.X) && (player.Y == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
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
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
				}
			}
		}
		return true;
	}
	
	public static boolean canPlayerMoveRight(MainClass mc)
	{
		BlockPlayer player = mc.player;
		for(int i = 0; i < MainClass.getEnemyList().size(); i++)
		{
			BlockEnemy enemy = MainClass.getEnemyList().get(i);
			if((player.X + 1 == enemy.X) && (player.Y == enemy.Y))
			{
				if(!EventCanHit.checkIfCanHit(mc))
				{
					action(mc);
					return false;
				}
				else
				{
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
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
					mc.killEnemy(enemy);
					mc.decreaseAfterHit();
				}
			}
		}
		return true;
	}
}
