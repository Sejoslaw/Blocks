package seia.gra.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.world.renderer.WorldRenderer;
import seia.gra.world.renderer.WorldRendererHeart;
import seia.gra.world.renderer.WorldRendererSquare;
import seia.gra.world.worldelement.WorldElement;
import seia.gra.world.worldelement.WorldElementLevelValue;

public class World 
{
	/**
	 * TODO: Swiat mozna przerobic na liste list -  List<List<Block>>
	 * Wtedy moglby sie rozszerzac.
	 * Jednak trzebaby przerobic wymiary swiata oraz przesowanie ekranu za graczem.
	 */
	public List<WorldElement> worldElement = new ArrayList<WorldElement>();
	public List<WorldRenderer> worldRenderer = new ArrayList<WorldRenderer>();
	public WorldRenderer currentRenderer;
	public int SZER, WYS;
	boolean b1;
	
	public World(int szer, int wys, boolean b1)
	{
		SZER = szer;
		WYS = wys;
		this.b1 = b1;
		addElements();
		addRenderers();
		if(b1)
			currentRenderer = worldRenderer.get(1);
		else
			currentRenderer = worldRenderer.get(0);
	}
	
	public boolean addElements()
	{
		try 
		{
			WorldElementLevelValue levelValue = new WorldElementLevelValue(13, 25);
			worldElement.add(levelValue);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addRenderers()
	{
		try
		{
			WorldRendererSquare square = new WorldRendererSquare(SZER, WYS);
			worldRenderer.add(square);
			if(b1)
			{
				WorldRendererHeart wrh = new WorldRendererHeart(SZER, WYS);
				worldRenderer.add(wrh);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < worldRenderer.size(); i++)
			if(worldRenderer.get(i).getRendererID() == currentRenderer.getRendererID())
				worldRenderer.get(i).paintWorld(g);
		for(int i = 0; i < worldElement.size(); i++)
			worldElement.get(i).paintComponent(g);
	}
	
	public boolean setCurrentRenderer(WorldRenderer renderer)
	{
		currentRenderer = renderer;
		if(currentRenderer.getRendererID() == renderer.getRendererID()) 
			return true;
		return false;
	}
	
	public boolean setCurrentRendererRandom()
	{
		int rand = new Random().nextInt(worldRenderer.size()) - 1;
		if(rand < 0) rand = 0;
		currentRenderer = worldRenderer.get(rand);
		if(currentRenderer.getRendererID() == worldRenderer.get(rand).getRendererID()) 
			return true;
		return false;
	}
}
