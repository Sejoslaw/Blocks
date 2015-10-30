package seia.gra.api.world;

import java.awt.Color;
import java.awt.Graphics;

public interface IWorldElement 
{
	Color getColor();
	String getElementName();
	void paintComponent(Graphics g);
}
