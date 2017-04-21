package main.java.kd.movingblocks.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;

/**
 * Enemy
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EntityEnemy extends Entity 
{
	public void renderEntity(Graphics g) 
	{
		Point startPos = getTopLeftPointToRender();
		g.setColor(Color.RED);
		g.fillRect(startPos.x, startPos.y, Settings.BLOCK_WIDTH, Settings.BLOCK_HEIGHT);
	}
}