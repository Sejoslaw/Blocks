package seia.gra.api.world;

import java.awt.Graphics;
import java.util.List;

import seia.gra.api.block.IBlockMovable;

public interface IWorldRenderer 
{
	int getSizeXInBlocks();
	int getSizeYInBlocks();
	boolean setWidth(int newWidth);
	boolean setHeight(int newHeight);
	int getMaxNumberOfEnemies();
	int getRendererID();
	boolean paintWorld(Graphics g);
	List<IBlockMovable> getMovableBlocksOnMap();
	IBlockMovable[][] getMovableBlocksOnMap(List<IBlockMovable> l);
	boolean canAdd(int x, int y, List<IBlockMovable> l);
}
