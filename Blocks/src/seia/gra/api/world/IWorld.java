package seia.gra.api.world;

import java.awt.Graphics;

public abstract interface IWorld 
{
	abstract void reloadPanel();
	abstract void killCurrentPlayer();
	abstract void findNextPlayerOnMap();
	abstract boolean addElements();
	abstract boolean addRenderers();
	abstract void paintComponent(Graphics g);
	abstract IWorld setCurrentRenderer(WorldRenderer renderer);
	abstract int countPlayerClones();
	abstract boolean arePlayerClonesOnWorld();
	abstract boolean areAllPlayerGone();
}
