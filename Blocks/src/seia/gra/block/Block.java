package seia.gra.block;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.world.World;

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
	
	public boolean isPlayer(World world)
	{
		if((world.player.X == X) && (world.player.Y == Y))
			return true;
		return false;
	}
	
	public boolean isEnemy(World world)
	{
		return world.isEnemyAtCoords(X, Y);
	}
	
	public Block getBlockOnLeft(World world)
	{
		return world.currentRenderer.world[X - 1][Y];
	}
	
	public Block getBlockOnLeft(World world, int ileWLewo)
	{
		return world.currentRenderer.world[X - ileWLewo][Y];
	}
	
	public Block getBlockOnRight(World world)
	{
		return world.currentRenderer.world[X + 1][Y];
	}
	
	public Block getBlockOnRight(World world, int ileWPrawo)
	{
		return world.currentRenderer.world[X + ileWPrawo][Y];
	}
	
	public Block getBlockOnTop(World world)
	{
		return world.currentRenderer.world[X][Y - 1];
	}
	
	public Block getBlockOnTop(World world, int ileWyzej)
	{
		return world.currentRenderer.world[X][Y - ileWyzej];
	}
	
	public Block getBlockUnder(World world)
	{
		return world.currentRenderer.world[X][Y + 1];
	}
	
	public Block getBlockUnder(World world, int ileNizej)
	{
		return world.currentRenderer.world[X][Y + ileNizej];
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
