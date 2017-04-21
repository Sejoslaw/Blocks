package main.java.kd.movingblocks.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.event.EventCloseGame;
import main.java.kd.movingblocks.event.EventFactory;
import main.java.kd.movingblocks.event.EventSwitchDebug;
import main.java.kd.movingblocks.event.EventTeleportPlayer;
import main.java.kd.movingblocks.event.move.EventMoveEntityDOWN;
import main.java.kd.movingblocks.event.move.EventMoveEntityLEFT;
import main.java.kd.movingblocks.event.move.EventMoveEntityRIGHT;
import main.java.kd.movingblocks.event.move.EventMoveEntityUP;

/**
 * KeyListener for MovingBlocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocksKeyListener implements KeyListener
{
	public void keyTyped(KeyEvent e) 
	{
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		// Events connected with Game and Player
		if (keyCode == Settings.Key.Movement.KEY_UP)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityUP(keyCode, MovingBlocks.INSTANCE.getPlayer()));
			moveEnemies(keyCode);
		}
		else if (keyCode == Settings.Key.Movement.KEY_DOWN)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityDOWN(keyCode, MovingBlocks.INSTANCE.getPlayer()));
			moveEnemies(keyCode);
		}
		else if (keyCode == Settings.Key.Movement.KEY_LEFT)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityLEFT(keyCode, MovingBlocks.INSTANCE.getPlayer()));
			moveEnemies(keyCode);
		}
		else if (keyCode == Settings.Key.Movement.KEY_RIGHT)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityRIGHT(keyCode, MovingBlocks.INSTANCE.getPlayer()));
			
			// Try to teleport Player
			if (MovingBlocks.INSTANCE.getPlayer().getY() == MovingBlocks.INSTANCE.getWorld().getTeleport().getY())
				if (MovingBlocks.INSTANCE.getPlayer().getX() == (MovingBlocks.INSTANCE.getWorld().getTeleport().getX() - 1))
				{
					EventFactory.INSTANCE.postEvent(new EventTeleportPlayer());
					return;
				}
			
			// Move enemies only if Player did not teleport
			moveEnemies(keyCode);
		}
		else if (keyCode == Settings.Debug.KEY_DEBUG)
		{
			EventFactory.INSTANCE.postEvent(new EventSwitchDebug());
		}
		else if (keyCode == Settings.Key.KEY_QUIT)
		{
			EventFactory.INSTANCE.postEvent(new EventCloseGame());
		}
	}
	
	public void keyReleased(KeyEvent e) 
	{
	}
	
	/**
	 * Move Enemies when Player moves.
	 * 
	 * @param keyCode
	 */
	private void moveEnemies(int keyCode)
	{
		Random rand = new Random();
		int direction = -1;
		for (int i = 0; i < MovingBlocks.INSTANCE.getWorld().getEnemies().size(); ++i)
		{
			direction = rand.nextInt(4); // randomize new direction for each Enemy
			if (direction == 0)
			{
				EventFactory.INSTANCE.postEvent(new EventMoveEntityUP(keyCode, MovingBlocks.INSTANCE.getWorld().getEnemies().get(i)));
			}
			else if (direction == 1)
			{
				EventFactory.INSTANCE.postEvent(new EventMoveEntityDOWN(keyCode, MovingBlocks.INSTANCE.getWorld().getEnemies().get(i)));
			}
			else if (direction == 2)
			{
				EventFactory.INSTANCE.postEvent(new EventMoveEntityLEFT(keyCode, MovingBlocks.INSTANCE.getWorld().getEnemies().get(i)));
			}
			else if (direction == 3)
			{
				EventFactory.INSTANCE.postEvent(new EventMoveEntityRIGHT(keyCode, MovingBlocks.INSTANCE.getWorld().getEnemies().get(i)));
			}
		}
	}
}