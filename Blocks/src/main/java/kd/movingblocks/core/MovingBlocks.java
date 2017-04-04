package main.java.kd.movingblocks.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Root class of the Moving Blocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocks 
{
	/**
	 * Current version of Moving Blocks - Last build time.
	 */
	public static final String VERSION = "2017.04.04-05.43.53";	/**
	 * Moving Blocks internal logger.
	 */
	public static final Logger LOGGER = Logger.getLogger("MovingBlocks");
	
	/**
	 * Add log using Moving Blocks logger.
	 */
	public static void log(Level level, String message)
	{
		LOGGER.log(level, message);
	}
}
