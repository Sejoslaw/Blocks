package main.java.kd.movingblocks.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.java.kd.movingblocks.event.EventFactory;
import main.java.kd.movingblocks.event.EventKeyPressed;

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
		EventFactory.INSTANCE.postEvent(new EventKeyPressed(keyCode));
	}
	
	public void keyReleased(KeyEvent e) 
	{
	}
}