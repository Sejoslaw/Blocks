package main.java.kd.movingblocks;

import java.awt.Dimension;

import com.sun.glass.events.KeyEvent;

/**
 * Contains all various global settings for Moving Blocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
 */
public class Settings 
{
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	public static final int TPS = 60; // Ticks Per Second
	
	public static final Dimension CANVAS_DIM = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	
	public static final int BLOCKS_IN_ROW = 15; // Row or Column
	public static final int BLOCK_WIDTH = FRAME_WIDTH / BLOCKS_IN_ROW;
	public static final int BLOCK_HEIGHT = FRAME_HEIGHT / BLOCKS_IN_ROW;
	
	/**
	 * Debug-related settings.
	 * 
	 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
	 */
	public static class Debug
	{
		/**
		 * Indicates if the Debug info should be shown.
		 */
		public static boolean SHOW_DEBUG = true;
		/**
		 * Debug Key
		 */
		public static int KEY_DEBUG = KeyEvent.VK_D;
	}
	
	/**
	 * Settings connected with Keys.
	 * 
	 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
	 */
	public static class Key
	{
		/**
		 * Key used for quitting the game.
		 */
		public static int KEY_QUIT = KeyEvent.VK_ESCAPE;
		
		/**
		 * Settings connected with Movement.
		 * 
		 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
		 */
		public static class Movement
		{
			public static int KEY_UP = KeyEvent.VK_UP;
			public static int KEY_DOWN = KeyEvent.VK_DOWN;
			public static int KEY_LEFT = KeyEvent.VK_LEFT;
			public static int KEY_RIGHT = KeyEvent.VK_RIGHT;
		}
	}
	
	/**
	 * Settings connected with Enemies
	 * 
	 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
	 */
	public static class Enemy
	{
		/**
		 * Number of the Enemies on the World when the game starts.
		 */
		public static int BASE_NUMBER_ON_WORLD = 10;
	}
	
	/**
	 * Settings connected with Player
	 * 
	 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
	 */
	public static class Player
	{
		/**
		 * Basic number of hits for each new Player.
		 */
		public static int BASE_HITS = 10;
	}
}