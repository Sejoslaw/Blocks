package seia.gra.api;

import seia.gra.api.world.IWorld;

public interface IMainClass 
{
	void newGame();
	boolean getSetHeart();
	int getWidthInBlocks();
	int getHeightInBlocks();
	int getSZER();
	int getWYS();
	String getNick();
	IWorld getWorldObj();
}
