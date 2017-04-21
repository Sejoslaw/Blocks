package main.java.kd.movingblocks.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.Settings;

/**
 * Main Player class.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EntityPlayer extends Entity
{
	/**
	 * Number of left hits which Player can do to Enemies.
	 */
	private int _hitsLeft = 10;
	
	/**
	 * @return Returns the number of hits which Player can use.
	 */
	public int getHits()
	{
		return this._hitsLeft;
	}
	
	/**
	 * Add hits for Player.
	 * 
	 * @param toAdd
	 */
	public void addHits(int toAdd)
	{
		this._hitsLeft += toAdd;
	}
	
	/**
	 * Method which is used when Player hits specified Enemy.
	 * 
	 * @param enemy Enemy which was hit by this Player.
	 */
	public void hitEnemy(Entity enemy)
	{
		if (this._hitsLeft > 0) 
			this._hitsLeft--;
		else if (this._hitsLeft == 0)
			MovingBlocks.INSTANCE.restartGame();
	}
	
	public void renderEntity(Graphics g)
	{
		Point startPos = getTopLeftPointToRender();
		g.setColor(Color.YELLOW);
		g.fillRect(startPos.x, startPos.y, Settings.BLOCK_WIDTH, Settings.BLOCK_HEIGHT);
	}
	
	public String toString()
	{
		return "EntityPlayer[X=" + getX() + ", Y=" + getY() + "]";
	}
}