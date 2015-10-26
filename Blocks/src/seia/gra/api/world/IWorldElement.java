package seia.gra.api.world;

import java.awt.Color;
import java.awt.Graphics;

public abstract interface IWorldElement 
{
	public abstract Color getColor();
	public abstract String getElementName();
	public abstract void paintComponent(Graphics g);
}
