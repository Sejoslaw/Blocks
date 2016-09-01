package seia.gra.world.worldrenderer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import seia.gra.block.Block;
import seia.gra.block.movable.BlockClonePlayer;
import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public class WorldRendererClonePlayer extends WorldRenderer
{
	public WorldRendererClonePlayer(int szer, int wys, World world) 
	{
		super(szer, wys, world);
	}
	
	public int getRendererID() 
	{
		return 2;
	}
	
	public boolean paintWorld(Graphics g) 
	{
		return false;
	}
	
	public List<BlockMovable> getMovableBlocksOnMap() 
	{
		List<BlockMovable> l = new ArrayList<BlockMovable>();
		l.add(new BlockClonePlayer(Block.getPlayerColor(), SZER - 1, WYS - 1, worldObj));
		return l;
	}
}