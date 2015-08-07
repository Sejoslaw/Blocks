package seia.gra.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import seia.gra.block.Block;

public class World 
{
	/**
	 * TODO: Swiat mozna przerobic na liste list -  List<List<Block>>
	 * Wtedy moglby sie rozszerzac.
	 * Jednak trzebaby przerobic wymiary swiata oraz przesowanie ekranu za graczem.
	 */
	public Block[][] world;
	public int SZER, WYS;
	public List<WorldElement> worldElement = new ArrayList<WorldElement>();
	
	public World(int szer, int wys)
	{
		SZER = szer;
		WYS = wys;
		world = new Block[szer / Block.BLOCK_SIZE][wys / Block.BLOCK_SIZE];
		
		try 
		{
			WorldElementLevelValue levelValue = new WorldElementLevelValue(13, 25);
			worldElement.add(levelValue);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
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
		for(int i = 0; i < worldElement.size(); i++)
		{
			worldElement.get(i).paintComponent(g);
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
