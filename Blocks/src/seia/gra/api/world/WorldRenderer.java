package seia.gra.api.world;

import java.awt.Graphics;
import java.util.List;

import seia.gra.block.Block;
import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public abstract class WorldRenderer
{
	public Block[][] world;
	public int SZER, WYS;
	public World worldObj;
	
	public WorldRenderer(int szer, int wys, World world)
	{
		SZER = szer;
		WYS = wys;
		worldObj = world;
		this.world = new Block[szer / Block.BLOCK_SIZE][wys / Block.BLOCK_SIZE];
	}
	
	public boolean setWidth(int newWidth)
	{
		SZER = newWidth;
		if(SZER == newWidth) 
			return true;
		return false;
	}
	
	public boolean setHeight(int newHeight)
	{
		WYS = newHeight;
		if(WYS == newHeight) 
			return true;
		return false;
	}
	
	public int getMaxNumberOfEnemies()
	{
		int sz = worldObj.mcInstance.getWidthInBlocks() - 2;
		int w = worldObj.mcInstance.getHeightInBlocks() - 2;
		int sr = (sz * w);
		return sr;
	}

	public abstract int getRendererID();
	public abstract boolean paintWorld(Graphics g);
	public abstract List<BlockMovable> getMovableBlocksOnMap();
}
