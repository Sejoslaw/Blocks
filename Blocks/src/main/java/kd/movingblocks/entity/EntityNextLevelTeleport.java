package main.java.kd.movingblocks.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.util.BlockPos;

/**
 * Teleporter to next level.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EntityNextLevelTeleport extends Entity 
{
	public void renderEntity(Graphics g) 
	{
		Point startPos = getTopLeftPointToRender();
		g.setColor(Color.GREEN);
		g.fillRect(startPos.x, startPos.y, Settings.BLOCK_WIDTH, Settings.BLOCK_HEIGHT);
	}
	
	/**
	 * Reloads the position of the Teleporter.
	 */
	public void reloadPosition()
	{
		this.setPosition(Settings.BLOCKS_IN_ROW - 1, BlockPos.getRandomCoord());
	}
}