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
	private int xLine = 3;
	
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
		if(Settings.Debug.SHOW_DEBUG == false) return;
		
		g.setColor(Color.YELLOW);
		g.drawString("Ticks: " + MovingBlocks.INSTANCE.getTicks(), xLine, 15);
		g.drawString("FPS: " + MovingBlocks.INSTANCE.getFPS(), xLine, 30);
	}
}