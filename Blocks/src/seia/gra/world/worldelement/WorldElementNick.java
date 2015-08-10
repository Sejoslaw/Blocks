package seia.gra.world.worldelement;

import java.awt.Color;
import java.awt.Graphics;

public class WorldElementNick extends WorldElement
{
	private static final Color color = Color.YELLOW;
	public String nick;
	
	public WorldElementNick(int pixelX, int pixelY) 
	{
		super(color, pixelX, pixelY);
	}

	@Override
	public String getElementName() 
	{
		return "nick";
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		Color tmp = g.getColor();
		g.setColor(color);
		g.drawString("Nick: " + nick, pixelX, pixelY);
		g.setColor(tmp);
	}
}
