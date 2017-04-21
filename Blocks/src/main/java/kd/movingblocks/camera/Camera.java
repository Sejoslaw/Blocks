package main.java.kd.movingblocks.camera;

import java.awt.Color;
import java.awt.Graphics;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.Settings;

/**
 * Camera is everything that should be rendered for Player.<br>
 * These are mainly 2D objects rendered for Player.<br>
 * For instance: mouse position, Player's health, etc.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class Camera 
{
	public static final Camera INSTANCE = new Camera();
	
	/**
	 * Line to the left
	 */
	private int _xLine = 3;
	/**
	 * This is the level of the World on which Player currently is.
	 * This is NOT the World id or any other value related with World itself.
	 */
	public int _level = 1;
	
	private Camera()
	{
	}

	/**
	 * Renders 2D elements for Player every render tick.
	 * 
	 * @param g
	 */
	public void renderScreen(Graphics g) 
	{
		showDebugInfo(g);
	}
	
	/**
	 * Renders 2D Debug Info
	 * 
	 * @param g
	 */
	private void showDebugInfo(Graphics g)
	{
		// Debug
		if(Settings.Debug.SHOW_DEBUG != false)
		{
			g.setColor(Color.YELLOW);
			g.drawString("Ticks: " + MovingBlocks.INSTANCE.getTicks(), _xLine, 15);
			g.drawString("FPS: " + MovingBlocks.INSTANCE.getFPS(), _xLine, 30);
		}
		
		g.setColor(Color.CYAN);
		g.drawString("Hits left: " + MovingBlocks.INSTANCE.getPlayer().getHits(), 2 * Settings.BLOCK_WIDTH + _xLine, 15);
		
		g.setColor(Color.GREEN);
		g.drawString("Level: " + this._level, 4 * Settings.BLOCK_WIDTH + _xLine, 15);
	}
	
	/**
	 * Indicate when to increase the current level.
	 */
	public void goToNextLevel()
	{
		this._level++;
	}
	
	/**
	 * This method should be fired when Player restarts game.
	 */
	public void restartGame()
	{
		this._level = 1;
	}
}