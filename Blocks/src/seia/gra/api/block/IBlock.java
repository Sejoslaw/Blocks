package seia.gra.api.block;

import java.awt.Color;
import java.awt.Graphics;

public interface IBlock 
{
	void paintComponent(Graphics g);
	boolean isPlayer();
	boolean isPlayerClone();
	boolean isEnemy();
	boolean canWalkThrough();
	IBlock setCanWalkThrough(boolean b);
	IBlock getBlockOnLeft();
	IBlock getBlockOnLeft(int ileWLewo);
	IBlock getBlockOnRight();
	IBlock getBlockOnRight(int ileWPrawo);
	IBlock getBlockOnTop();
	IBlock getBlockOnTop(int ileWyzej);
	IBlock getBlockUnder();
	IBlock getBlockUnder(int ileNizej);
	boolean hasMovable(int posX, int posY);
	Color getColor();
	boolean setColor(Color newColor);
	void setX(int newX);
	void setY(int newY);
}
