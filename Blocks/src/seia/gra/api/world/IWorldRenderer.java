package seia.gra.api.world;

import java.awt.Graphics;
import java.util.List;

import seia.gra.api.block.IBlockMovable;

public abstract interface IWorldRenderer 
{
	public abstract int getSizeXInBlocks();
	public abstract int getSizeYInBlocks();
	public abstract boolean setWidth(int newWidth);
	public abstract boolean setHeight(int newHeight);
	public abstract int getMaxNumberOfEnemies();
	public abstract int getRendererID();
	public abstract boolean paintWorld(Graphics g);
	public abstract List<IBlockMovable> getMovableBlocksOnMap();
	public abstract IBlockMovable[][] getMovableBlocksOnMap(List<IBlockMovable> l);
	public abstract boolean canAdd(int x, int y, List<IBlockMovable> l);
}
