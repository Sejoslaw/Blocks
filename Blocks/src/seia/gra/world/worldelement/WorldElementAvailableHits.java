package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementAvailableHits extends WorldElement
{
	private static final Color color = Color.CYAN;
	public int availableHits = 10;
	
	public WorldElementAvailableHits(int pixelX, int pixelY) 
	{
		super(color, pixelX, pixelY);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}

	@Override
	public String getElementName() 
	{
		return "availableHits";
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(color);
		g.drawString("Available hits: " + availableHits, pixelX, pixelY);
		g.setColor(tmp);
	}
}
