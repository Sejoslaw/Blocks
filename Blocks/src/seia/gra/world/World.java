package seia.gra.world;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.block.Block;

public class World 
{
	public Block[][] world;
	public int SZER, WYS;
	
	public World(int szer, int wys)
	{
		SZER = szer;
		WYS = wys;
		world = new Block[szer / Block.BLOCK_SIZE][wys / Block.BLOCK_SIZE];
	}
	
	public void paintComponent(Graphics g)
	{
		for(int x = 0; x < SZER / 50; x++)
		{
			for(int y = 0; y < WYS / 50; y++)
			{
				if(x == 0 || y == 0 || x == (SZER / 50) - 1 || y == (WYS / 50) - 1)
				{
					world[x][y] = new Block(Color.BLACK, x, y);
					world[x][y].paintComponent(g);
				}
				else
				{
					world[x][y] = new Block(Color.BLUE, x, y);
					world[x][y].paintComponent(g);
				}
			}
		}
	}
	
	public boolean setWidth(int newWidth)
	{
		SZER = newWidth;
		if(SZER == newWidth) return true;
		return false;
	}
	
	public boolean setHeight(int newHeight)
	{
		WYS = newHeight;
		if(WYS == newHeight) return true;
		return false;
	}
}
