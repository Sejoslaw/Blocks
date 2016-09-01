package seia.gra.world;

import java.util.ArrayList;
import java.util.List;

import seia.gra.world.worldelement.WorldElement;
import seia.gra.world.worldrenderer.WorldRenderer;

public class WorldRegistry 
{
	public static final WorldRegistry INSTANCE = new WorldRegistry();
	
	public List<WorldElement> WORLD_ELEMENTS = new ArrayList<WorldElement>();
	public List<WorldRenderer> WORLD_RENDERERS = new ArrayList<WorldRenderer>();
	
	private WorldRegistry(){}
}