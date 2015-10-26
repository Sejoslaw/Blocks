package seia.gra.world.worldrenderer;

import java.awt.Graphics;
import java.util.List;

import seia.gra.api.block.IBlockMovable;
import seia.gra.api.world.IWorldRenderer;
import seia.gra.block.Block;
import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public abstract class WorldRenderer implements IWorldRenderer
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
	
	public int getSizeXInBlocks()
	{
		return SZER / Block.BLOCK_SIZE;
	}
	
	public int getSizeYInBlocks()
	{
		return WYS / Block.BLOCK_SIZE;
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
	
	public BlockMovable[][] getMovableBlocksOnMap(List<IBlockMovable> l)
	{
		int sizeX = worldObj.getSizeXInBlocks();
		int sizeY = worldObj.getSizeYInBlocks();
		BlockMovable[][] movTab = new BlockMovable[sizeX][sizeY];
		for(int i = 0; i < l.size(); i++)
		{
			BlockMovable bm = (BlockMovable) l.get(i);
			movTab[bm.X][bm.Y] = bm;
		}
		return movTab;
	}

	public boolean canAdd(int x, int y, List<IBlockMovable> l)
	{
		BlockMovable[][] movTab = getMovableBlocksOnMap(l);
		if(movTab[x][y] == null)
			return true;
		return false;
	}

	public abstract int getRendererID();
	public abstract boolean paintWorld(Graphics g);
	public abstract List<IBlockMovable> getMovableBlocksOnMap();
}
