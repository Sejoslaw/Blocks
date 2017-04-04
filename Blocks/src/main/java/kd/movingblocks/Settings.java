package main.java.kd.movingblocks;

import java.awt.Dimension;

/**
 * Contains all various global settings for Moving Blocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
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
}