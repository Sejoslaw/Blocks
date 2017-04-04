package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementAvailableHits extends WorldElement
{
	private static final Color COLOR = Color.CYAN;
	public int availableHits = 10;
	
	public WorldElementAvailableHits(int pixelX, int pixelY) 
	{
		super(COLOR, pixelX, pixelY);
	}
	
	public Color getColor()
	{
		return COLOR;
	}
	
	public String getElementName() 
	{
		return "availableHits";
	}
	
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(COLOR);
		g.drawString("Available hits: " + availableHits, pixelX, pixelY);
		g.setColor(tmp);
	}
}