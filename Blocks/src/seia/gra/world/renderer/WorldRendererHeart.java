package seia.gra.world.renderer;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.block.Block;

public class WorldRendererHeart extends WorldRenderer
{
	public static final String input = "kamila";
	
	public WorldRendererHeart(int szer, int wys) 
	{
		super(szer, wys);
	}

	@Override
	public int getRendererID() 
	{
		return 1;
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
		for(int x = 6; x < 14; x++)
		{
			for(int y = 4; y < 7; y++)
			{
				world[x][y] = new Block(Color.RED, x, y);
				world[x][y].paintComponent(g);
			}
		}
		world[6][6] = new Block(Color.BLUE, 6, 6);
		world[6][6].paintComponent(g);
		world[13][6] = new Block(Color.BLUE, 13, 6);
		world[13][6].paintComponent(g);
		
		world[7][3] = new Block(Color.RED, 7, 3);
		world[7][3].paintComponent(g);
		world[8][3] = new Block(Color.RED, 8, 3);
		world[8][3].paintComponent(g);
		world[11][3] = new Block(Color.RED, 11, 3);
		world[11][3].paintComponent(g);
		world[12][3] = new Block(Color.RED, 12, 3);
		world[12][3].paintComponent(g);
		
		world[8][7] = new Block(Color.RED, 8, 7);
		world[8][7].paintComponent(g);
		world[9][7] = new Block(Color.RED, 9, 7);
		world[9][7].paintComponent(g);
		world[10][7] = new Block(Color.RED, 10, 7);
		world[10][7].paintComponent(g);
		world[11][7] = new Block(Color.RED, 11, 7);
		world[11][7].paintComponent(g);
		world[9][8] = new Block(Color.RED, 9, 8);
		world[9][8].paintComponent(g);
		world[10][8] = new Block(Color.RED, 10, 8);
		world[10][8].paintComponent(g);
		return false;
	}
}
