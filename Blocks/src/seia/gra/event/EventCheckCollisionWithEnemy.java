package seia.gra.event;

import seia.gra.MainClass;
import seia.gra.block.BlockEnemy;
import seia.gra.block.BlockPlayer;

public class EventCheckCollisionWithEnemy extends Event
{
	public static boolean canPlayerMoveUp(MainClass mc)
	{
		BlockPlayer player = mc.player;
		for(int i = 0; i < MainClass.getEnemyList().size(); i++)
		{
			BlockEnemy enemy = MainClass.getEnemyList().get(i);
			if((player.X == enemy.X) && (player.Y - 1 == enemy.Y))
			{
				mc.gameOver();
				return false;
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
				mc.gameOver();
				return false;
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
				mc.gameOver();
				return false;
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
				mc.gameOver();
				return false;
			}
		}
		return true;
	}
	
}
