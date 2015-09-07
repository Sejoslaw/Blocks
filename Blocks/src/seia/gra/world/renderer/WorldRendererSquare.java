package seia.gra.world.renderer;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.block.Block;
import seia.gra.world.World;

public class WorldRendererSquare extends WorldRenderer
{
	public WorldRendererSquare(int szer, int wys, World world) 
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
}
