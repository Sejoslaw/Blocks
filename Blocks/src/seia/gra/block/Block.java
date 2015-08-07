package seia.gra.block;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Block extends JPanel
{
	private static final long serialVersionUID = 1L;
	
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
		return null;
	}
	
	public boolean setColor(Color c)
	{
		this.c = c;
		return true;
	}
}
