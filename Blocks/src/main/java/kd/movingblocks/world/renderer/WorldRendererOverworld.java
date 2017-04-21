package main.java.kd.movingblocks.world.renderer;

import java.awt.Graphics;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.util.BlockPos;

/**
 * Standard Overworld renderer.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class WorldRendererOverworld extends WorldRenderer
{
	public WorldRendererOverworld(int dimId) 
	{
		super(dimId);
	}
	
	public void renderWorld(Graphics g) 
	{
		// Render background
		for (int x = 0; x < Settings.BLOCKS_IN_ROW; ++x)
			for (int y = 0; y < Settings.BLOCKS_IN_ROW; ++y)
			{
				BlockPos pos = new BlockPos(x, y);
				getWorld().getBlock(pos).renderBlock(g, countStartRenderPos(pos));
			}
		
		// Render Enemies
		for (int i = 0; i < getWorld().getEnemies().size(); ++i)
			getWorld().getEnemies().get(i).renderEntity(g);
		
		// Render teleporter
		getWorld().getTeleport().renderEntity(g);
	}
}