package seia.gra.api.world;

import java.awt.Graphics;

public interface IWorld 
{
	void reloadPanel();
	void killCurrentPlayer();
	void findNextPlayerOnMap();
	boolean addElements();
	boolean addRenderers();
	void paintComponent(Graphics g);
	IWorld setCurrentRenderer(IWorldRenderer renderer);
	int countPlayerClones();
	boolean arePlayerClonesOnWorld();
	boolean areAllPlayerGone();
}
