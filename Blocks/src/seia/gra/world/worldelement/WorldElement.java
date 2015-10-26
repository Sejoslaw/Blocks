package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.api.world.IWorldElement;

public abstract class WorldElement implements IWorldElement
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
