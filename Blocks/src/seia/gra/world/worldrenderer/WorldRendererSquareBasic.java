package seia.gra.world.worldrenderer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.api.world.WorldRenderer;
import seia.gra.block.Block;
import seia.gra.block.background.BlockAir;
import seia.gra.block.background.BlockWall;
import seia.gra.block.movable.BlockClonePlayer;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.BlockMovable;
import seia.gra.world.World;

public class WorldRendererSquareBasic extends WorldRenderer
{
	public WorldRendererSquareBasic(int szer, int wys, World world) 
	{
		super(szer, wys, world);
	}

	@Override
	public int getRendererID() 
	{
		return 0;
	}

	@Override
	public boolean paintWorld(Graphics g) 
	{
		for(int x = 0; x < SZER / Block.BLOCK_SIZE; x++)
		{
			for(int y = 0; y < WYS / Block.BLOCK_SIZE; y++)
			{
				if(x == 0 || y == 0 || x == (SZER / Block.BLOCK_SIZE) - 1 || y == (WYS / Block.BLOCK_SIZE) - 1)
				{
					world[x][y] = new BlockWall(x, y, worldObj);
					world[x][y].paintComponent(g);
				}
				else
				{
					world[x][y] = new BlockAir(x, y, worldObj);
					world[x][y].paintComponent(g);
				}
			}
		}
		return false;
	}

	@Override
	public List<BlockMovable> getMovableBlocksOnMap() 
	{
		List<BlockMovable> l = new ArrayList<BlockMovable>();
		int ile = getMaxNumberOfEnemies();
		for(int i = 0; i < ile; i++) //procentowo, rozne rozmiary planszy (nastepny poziom -> wiecej czerwonych)
		{
			int rX = new Random().nextInt(worldObj.mcInstance.SZER / Block.BLOCK_SIZE);
			if(rX < 1) rX = 1;
			if(rX > (worldObj.mcInstance.SZER / Block.BLOCK_SIZE) - 1) rX = (worldObj.mcInstance.SZER / Block.BLOCK_SIZE) - 1;
			int rY = new Random().nextInt(worldObj.mcInstance.WYS / Block.BLOCK_SIZE);
			if(rY < 1) rY = 1;
			if(rY > (worldObj.mcInstance.WYS / Block.BLOCK_SIZE) - 1) rY = (worldObj.mcInstance.WYS / Block.BLOCK_SIZE) - 1;
			if(		   (rX != 1) 
					&& (rY != 1) 
					&& (rX != 0) 
					&& (rY != 0) 
					&& (rX != worldObj.mcInstance.getWidthInBlocks() - 1) 
					&& (rY != worldObj.mcInstance.getHeightInBlocks() - 1))
			{
				if(canAdd(rX, rY, l))
				{
					l.add(new BlockEnemy(rX, rY, worldObj));
				}
			}
		}
		for(int i = 0; i < l.size(); i++)
		{
			if(l.get(i) != null)
			{
				BlockMovable bm = l.get(i);
				if((bm.X == worldObj.mcInstance.getWidthInBlocks() - 1)
					&& (bm.Y == worldObj.mcInstance.getHeightInBlocks() - 1))
				{
					l.remove(bm);
				}
			}
		}
		l.add(new BlockClonePlayer(Block.getPlayerColor() ,
				worldObj.mcInstance.getWidthInBlocks() - 2, 
				worldObj.mcInstance.getHeightInBlocks() - 2, 
				worldObj));
		return l;
	}
	
	public BlockMovable[][] getMovableBlocksOnMap(List<BlockMovable> l) 
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

	public boolean canAdd(int x, int y, List<BlockMovable> l)
	{
		BlockMovable[][] movTab = getMovableBlocksOnMap(l);
		if(movTab[x][y] == null)
			return true;
		return false;
	}
}
