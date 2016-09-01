package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementNick extends WorldElement
{
	private static final Color COLOR = Color.ORANGE;
	public String nick;
	
	public WorldElementNick(int pixelX, int pixelY) 
	{
		super(COLOR, pixelX, pixelY);
	}
	
	public String getElementName() 
	{
		return "nick";
	}
	
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(COLOR);
		g.drawString("Nick: " + nick, pixelX, pixelY);
		g.setColor(tmp);
	}
}