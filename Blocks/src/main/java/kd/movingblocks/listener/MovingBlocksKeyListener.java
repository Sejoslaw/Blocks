package main.java.kd.movingblocks.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.event.EventCloseGame;
import main.java.kd.movingblocks.event.EventFactory;
import main.java.kd.movingblocks.event.EventSwitchDebug;
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
		if (keyCode == Settings.Key.Movement.KEY_UP)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityUP(keyCode, MovingBlocks.INSTANCE.getPlayer()));
		}
		else if (keyCode == Settings.Key.Movement.KEY_DOWN)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityDOWN(keyCode, MovingBlocks.INSTANCE.getPlayer()));
		}
		else if (keyCode == Settings.Key.Movement.KEY_LEFT)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityLEFT(keyCode, MovingBlocks.INSTANCE.getPlayer()));
		}
		else if (keyCode == Settings.Key.Movement.KEY_RIGHT)
		{
			EventFactory.INSTANCE.postEvent(new EventMoveEntityRIGHT(keyCode, MovingBlocks.INSTANCE.getPlayer()));
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
}