package seia.gra.api.block;

import java.awt.Color;
import java.awt.Graphics;

import seia.gra.api.world.IWorld;

public interface IBlock 
{
	Color getColor();
	int getPosX();
	int getPosY();
	IWorld getWorld();
	boolean setColor(Color newColor);
	void setX(int newX);
	void setY(int newY);
	IBlock setCanWalkThrough(boolean b);
	void paintComponent(Graphics g);
	boolean isPlayer();
	boolean isPlayerClone();
	boolean isEnemy();
	boolean canWalkThrough();
	IBlock getBlockOnLeft();
	IBlock getBlockOnLeft(int ileWLewo);
	IBlock getBlockOnRight();
	IBlock getBlockOnRight(int ileWPrawo);
	IBlock getBlockOnTop();
	IBlock getBlockOnTop(int ileWyzej);
	IBlock getBlockUnder();
	IBlock getBlockUnder(int ileNizej);
	boolean hasMovable(int posX, int posY);
}
