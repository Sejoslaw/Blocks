package seia.gra.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class WorldElement 
{
	public Color c;
	public int pixelX, pixelY;
	public static final List<WorldElement> WORLD_ELEMENT_BUS = new ArrayList<WorldElement>();
	
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
