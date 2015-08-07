package seia.gra.block;

import java.awt.Color;
import java.awt.Graphics;

public class Block
{
	private static final int SIZE = 50;
	public static final int BLOCK_SIZE = SIZE;
	
	public static boolean isShowingLines = false;
	
	public int X, Y;
	private Color c;
	
	public Block(Color c, int x, int y)
	{
		this.c = c;
		this.X = x;
		this.Y = y;
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
	
	public boolean setX(int newX)
	{
		X = newX;
		if(X == newX) return true;
		return false;
	}
	
	public boolean setY(int newY)
	{
		Y = newY;
		if(Y == newY) return true;
		return false;
	}
}
