package seia.gra.block;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import seia.gra.world.World;

public class Block
{
	private static final int SIZE = 50;
	public static final int BLOCK_SIZE = SIZE;
	
	public static boolean isShowingLines = true;
	
	public int X, Y;
	private Color c;
	public World worldObj;
	
	public static List<Block> blocksInGame = new ArrayList<Block>();
	
	public Block(Color c, int x, int y, World world)
	{
		this.c = c;
		this.X = x;
		this.Y = y;
		worldObj = world;
		blocksInGame.add(this);
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(c);
		g.fillRect(SIZE * X,SIZE * Y, SIZE, SIZE);
		
		if(isShowingLines)
		{
			g.setColor(Color.RED);
			g.drawRect(SIZE * X, SIZE * Y, SIZE, SIZE);
		}
	}
	
	public boolean isPlayer()
	{
		return false;
	}
	
	public boolean isEnemy()
	{
		return false;
	}
	
	public Block getBlockOnLeft()
	{
		return worldObj.currentRenderer.world[X - 1][Y];
	}
	
	public Block getBlockOnLeft(int ileWLewo)
	{
		return worldObj.currentRenderer.world[X - ileWLewo][Y];
	}
	
	public Block getBlockOnRight()
	{
		return worldObj.currentRenderer.world[X + 1][Y];
	}
	
	public Block getBlockOnRight(int ileWPrawo)
	{
		return worldObj.currentRenderer.world[X + ileWPrawo][Y];
	}
	
	public Block getBlockOnTop()
	{
		return worldObj.currentRenderer.world[X][Y - 1];
	}
	
	public Block getBlockOnTop(int ileWyzej)
	{
		return worldObj.currentRenderer.world[X][Y - ileWyzej];
	}
	
	public Block getBlockUnder()
	{
		return worldObj.currentRenderer.world[X][Y + 1];
	}
	
	public Block getBlockUnder(int ileNizej)
	{
		return worldObj.currentRenderer.world[X][Y + ileNizej];
	}
	
	public Color getColor() 
	{
		return c;
	}
	
	public boolean setColor(Color newColor)
	{
		c = newColor;
		if((c.getRGB() == newColor.getRGB())) return true;
		return false;
	}
	
	public void setX(int newX)
	{
		X = newX;
	}
	
	public void setY(int newY)
	{
		Y = newY;
	}
}
