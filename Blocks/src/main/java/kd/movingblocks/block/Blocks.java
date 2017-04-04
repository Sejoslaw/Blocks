package main.java.kd.movingblocks.block;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import main.java.kd.jkdl.graphics.JKDLColor;

/**
 * Class which contains all data about all types of blocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public abstract class Blocks
{
	/**
	 * Contains data about all currently registered blocks.
	 */
	public static final Set<Block> BLOCKS = new HashSet<Block>();
	
	public static final Block VOID = new Block(-2, Color.BLACK);
	public static final Block AIR = new Block(-1, Color.WHITE);
	public static final Block DIRT = new Block(0, JKDLColor.BLANCHEDALMOND);
	public static final Block SAND = new Block(1, JKDLColor.GOLDENROD);
}