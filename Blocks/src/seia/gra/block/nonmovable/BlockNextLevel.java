package seia.gra.block.nonmovable;

import java.awt.Color;
import java.util.Random;

import seia.gra.MainClass;

public class BlockNextLevel extends BlockNonMovable
{
	private static Color color = Color.YELLOW;
	
	public BlockNextLevel(int x, int y) 
	{
		super(color, x, y);
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
		int rand = new Random().nextInt(MainClass.getHeightInBlocks());
		if(rand == 0) 
			rand++;
		if(rand == MainClass.getHeightInBlocks())
			rand--;
		return rand;
	}
}
