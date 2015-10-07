package seia.gra.world.renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.block.Block;
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
		for(int x = 0; x < SZER / 50; x++)
		{
			for(int y = 0; y < WYS / 50; y++)
			{
				if(x == 0 || y == 0 || x == (SZER / 50) - 1 || y == (WYS / 50) - 1)
				{
					world[x][y] = new Block(Color.BLACK, x, y, worldObj);
					world[x][y].paintComponent(g);
				}
				else
				{
					world[x][y] = new Block(Color.BLUE, x, y, worldObj);
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
		int ile = 180;
		for(int i = 0; i < ile; i++) //procentowo, rozne rozmiary planszy (nastepny poziom -> wiecej czerwonych)
		{
			int rX = new Random().nextInt(worldObj.mcInstance.SZER / Block.BLOCK_SIZE);
			int rY = new Random().nextInt(worldObj.mcInstance.WYS / Block.BLOCK_SIZE);
			if(		   (rX != 1) 
					&& (rY != 1) 
					&& (rX != 0) 
					&& (rY != 0) 
					&& (rX != worldObj.mcInstance.getWidthInBlocks() - 1) 
					&& (rY != worldObj.mcInstance.getHeightInBlocks() - 1))
			{
				l.add(new BlockEnemy(rX, rY, worldObj));
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
}
