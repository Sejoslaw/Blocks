package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementLevelValue extends WorldElement
{
	public int level;
	private static Color COLOR = Color.YELLOW;
	
	public WorldElementLevelValue(int pixelX, int pixelY) 
	{
		super(COLOR, pixelX, pixelY);
		level = 1;
	}
	
	public Color getColor()
	{
		return COLOR;
	}
	
	public String getElementName() 
	{
		return "levelValue";
	}
	
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(COLOR);
		g.drawString("Level: " + level, pixelX, pixelY);
		g.setColor(tmp);
	}
}