package seia.gra.block.nonmovable;

import java.awt.Color;
import java.util.Random;

import seia.gra.MainClass;
import seia.gra.world.World;

public class BlockNextLevel extends BlockNonMovable
{
	private static Color color = Color.YELLOW;
	
	public BlockNextLevel(int x, int y, World world) 
	{
		super(color, x, y, world);
	}
	
	@Override
	public Color getColor()
	{
		return color;
	}

	public static int getWidth() 
	{
		return MainClass.getWidthInBlocks() - 1;
	}

	public static int getRandHeight() 
	{
		int rand = new Random().nextInt((3 * MainClass.getHeightInBlocks()) / 4);
		if(rand <= 0) rand = 1;
		return rand;
	}
}
