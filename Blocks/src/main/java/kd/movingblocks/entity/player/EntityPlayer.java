package main.java.kd.movingblocks.entity.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.entity.Entity;

/**
 * Main Player class.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EntityPlayer extends Entity
{
	public void renderEntity(Graphics g)
	{
		Point startPos = getTopLeftPointToRender();
		g.setColor(Color.YELLOW);
		g.fillRect(startPos.x, startPos.y, Settings.BLOCK_WIDTH, Settings.BLOCK_HEIGHT);
	}
}