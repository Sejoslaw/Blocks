package seia.gra.world;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.block.Block;
import seia.gra.block.BlockMovable;

public class World 
{
	public BlockMovable[][] world;
	public int SZER, WYS;
	
	public World(int szer, int wys)
	{
		SZER = szer;
		WYS = wys;
		world = new BlockMovable[szer / Block.BLOCK_SIZE][wys / Block.BLOCK_SIZE];
	}
	
	public void paintComponent(Graphics g)
	{
		for(int x = 0; x < SZER / 50; x++)
		{
			for(int y = 0; y < WYS / 50; y++)
			{
				if(x == 0 || y == 0 || x == (SZER / 50) - 1 || y == (WYS / 50) - 1)
				{
					world[x][y] = new BlockMovable(Color.BLACK, x, y);
					world[x][y].paintComponent(g);
				}
				else
				{
					world[x][y] = new BlockMovable(Color.BLUE, x, y);
					world[x][y].paintComponent(g);
				}
			}
		}
	}
}
