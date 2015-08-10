package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementLevelValue extends WorldElement
{
	public int level;
	private static Color color = Color.YELLOW;
	
	public WorldElementLevelValue(int pixelX, int pixelY) 
	{
		super(color, pixelX, pixelY);
		level = 1;
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}
	
	@Override
	public String getElementName() 
	{
		return "levelValue";
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(color);
		g.drawString("Level: " + level, pixelX, pixelY);
		g.setColor(tmp);
	}
}
