package seia.gra.api.world;

import java.util.ArrayList;
import java.util.List;

public class WorldRegistry 
{
	public static final WorldRegistry INSTANCE = new WorldRegistry();
	
	private List<IWorldElement> worldElement = new ArrayList<IWorldElement>();
	private List<IWorldRenderer> worldRenderer = new ArrayList<IWorldRenderer>();
	
	private WorldRegistry()
	{
	}
	
	public void addWorldElement(IWorldElement element)
	{
		worldElement.add(element);
	}
	
	public List<IWorldElement> getWorldElements()
	{
		return worldElement;
	}
	
	public void addWorldRenderer(IWorldRenderer renderer)
	{
		worldRenderer.add(renderer);
	}
	
	public List<IWorldRenderer> getWorldRenderers()
	{
		return worldRenderer;
	}
}
