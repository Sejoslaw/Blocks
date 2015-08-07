package seia.gra.world;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementLevelValue extends WorldElement
{
	public String name;
	public int level;
	private static Color color = Color.YELLOW;
	
	public WorldElementLevelValue(int pixelX, int pixelY) 
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
		return "levelValue";
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		g.setColor(c);
	}
}
