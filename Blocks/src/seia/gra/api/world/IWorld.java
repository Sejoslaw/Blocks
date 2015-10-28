package seia.gra.api.world;

import java.awt.Graphics;

public interface IWorld 
{
	public void reloadPanel();
	public void killCurrentPlayer();
	public void findNextPlayerOnMap();
	public boolean addElements();
	public boolean addRenderers();
	public void paintComponent(Graphics g);
	public IWorld setCurrentRenderer(IWorldRenderer renderer);
	public int countPlayerClones();
	public boolean arePlayerClonesOnWorld();
	public boolean areAllPlayerGone();
}
