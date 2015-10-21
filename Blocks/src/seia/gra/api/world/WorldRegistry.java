package seia.gra.api.world;

import java.util.ArrayList;
import java.util.List;

public class WorldRegistry 
{
	public static final WorldRegistry INSTANCE = new WorldRegistry();
	
	private List<WorldElement> worldElement = new ArrayList<WorldElement>();
	private List<WorldRenderer> worldRenderer = new ArrayList<WorldRenderer>();
	
	private WorldRegistry()
	{
	}
	
	public void addWorldElement(WorldElement element)
	{
		worldElement.add(element);
	}
	
	public List<WorldElement> getWorldElements()
	{
		return worldElement;
	}
	
	public void addWorldRenderer(WorldRenderer renderer)
	{
		worldRenderer.add(renderer);
	}
	
	public List<WorldRenderer> getWorldRenderers()
	{
		return worldRenderer;
	}
}
