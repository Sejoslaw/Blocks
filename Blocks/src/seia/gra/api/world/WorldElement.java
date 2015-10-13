package seia.gra.api.world;

import java.awt.Color;
import java.awt.Graphics;

public abstract class WorldElement 
{
	public Color c;
	public int pixelX, pixelY;
	
	public WorldElement(Color c, int pixelX, int pixelY)
	{
		this.c = c;
		this.pixelX = pixelX;
		this.pixelY = pixelY;
	}
	
	public Color getColor()
	{
		return c;
	}
	
	public abstract String getElementName();
	public abstract void paintComponent(Graphics g);
}
