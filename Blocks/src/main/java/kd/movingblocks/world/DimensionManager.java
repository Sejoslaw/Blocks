package main.java.kd.movingblocks.world;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.java.kd.movingblocks.world.renderer.WorldRenderer;

/**
 * Holds data about all Worlds.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class DimensionManager 
{
	/**
	 * Holds information about all currently existing Worlds.
	 */
	private static Map<Integer, World> _WORLDS = new HashMap<>();
	
	/**
	 * Create and add new World. 
	 * If World with the specified dimId already exists returns this World instead.
	 * 
	 * @param dimId Id of the new World.
	 * @param rendererClass Class of the renderer for new World.
	 */
	public static World createNewWorld(int dimId, Class<? extends WorldRenderer> rendererClass) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException
	{
		if (_WORLDS.containsKey(dimId)) 
			return _WORLDS.get(dimId);
		
		WorldRenderer renderer = rendererClass.getConstructor(int.class).newInstance(dimId);
		World world = new World(dimId, renderer);
		_WORLDS.put(dimId, world);
		return world;
	}
	
	/**
	 * @param dimId
	 * @return Returns World with the specified dimension Id 
	 * if World not exists it will return World with dimId = 0;
	 */
	public static World getWorldByDimId(int dimId)
	{
		for (Entry<Integer, World> entry : _WORLDS.entrySet())
		{
			World world = entry.getValue();
			if (world.getDimensionId() == dimId)
				return world;
		}
		return getWorldByDimId(0);
	}
}