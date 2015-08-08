package seia.gra.world.renderer;

import java.awt.Graphics;

import seia.gra.block.Block;

public abstract class WorldRenderer 
{
	public Block[][] world;
	public int SZER, WYS;
	
	public WorldRenderer(int szer, int wys)
	{
		SZER = szer;
		WYS = wys;
		world = new Block[szer / Block.BLOCK_SIZE][wys / Block.BLOCK_SIZE];
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
	
	public abstract int getRendererID();
	public abstract boolean paintWorld(Graphics g);
}
