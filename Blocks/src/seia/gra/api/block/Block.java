package seia.gra.api.block;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.block.movable.player.BlockPlayer;
import seia.gra.world.World;

public class Block
{
	private static final int SIZE = 50;
	public static final int BLOCK_SIZE = SIZE;
	
	public static boolean isShowingLines = true;
	
	public int X, Y;
	private Color c;
	public World worldObj;
	
	public static List<Block> blocksInGame = new ArrayList<Block>();
	
	public Block(Color c, int x, int y, World world)
	{
		this.c = c;
		this.X = x;
		this.Y = y;
		worldObj = world;
		blocksInGame.add(this);
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(c);
		g.fillRect(SIZE * X,SIZE * Y, SIZE, SIZE);
		
		if(isShowingLines)
		{
			g.setColor(Color.RED);
			g.drawRect(SIZE * X, SIZE * Y, SIZE, SIZE);
		}
	}
	
	public boolean isPlayer()
	{
		return false;
	}
	
	public boolean isPlayerClone()
	{
		return false;
	}
	
	public boolean isEnemy()
	{
		return false;
	}
	
	public boolean canWalkThrought()
	{
		return false;
	}
	
	public Block getBlockOnLeft()
	{
		return worldObj.currentRenderer.world[X - 1][Y];
	}
	
	public Block getBlockOnLeft(int ileWLewo)
	{
		return worldObj.currentRenderer.world[X - ileWLewo][Y];
	}
	
	public Block getBlockOnRight()
	{
		return worldObj.currentRenderer.world[X + 1][Y];
	}
	
	public Block getBlockOnRight(int ileWPrawo)
	{
		return worldObj.currentRenderer.world[X + ileWPrawo][Y];
	}
	
	public Block getBlockOnTop()
	{
		return worldObj.currentRenderer.world[X][Y - 1];
	}
	
	public Block getBlockOnTop(int ileWyzej)
	{
		return worldObj.currentRenderer.world[X][Y - ileWyzej];
	}
	
	public Block getBlockUnder()
	{
		return worldObj.currentRenderer.world[X][Y + 1];
	}
	
	public Block getBlockUnder(int ileNizej)
	{
		return worldObj.currentRenderer.world[X][Y + ileNizej];
	}
	
	public static Color getPlayerColor()
	{
		for(int x = 0; x < blocksInGame.size(); x++)
			if(blocksInGame.get(x) instanceof BlockPlayer)
				return blocksInGame.get(x).getColor();
		return null;
	}
	
	public boolean hasMovable(int posX, int posY)
	{
		for(int i = 0; i < worldObj.currentTiles.size(); i++)
			if((posY == worldObj.currentTiles.get(i).Y) && (posX == worldObj.currentTiles.get(i).X))
				return true;
		return false;
	}
	
	public Color getColor() 
	{
		return c;
	}
	
	public boolean setColor(Color newColor)
	{
		c = newColor;
		if((c.getRGB() == newColor.getRGB())) return true;
		return false;
	}
	
	public void setX(int newX)
	{
		X = newX;
	}
	
	public void setY(int newY)
	{
		Y = newY;
	}
	
	public int getWidth() 
	{
		return worldObj.mcInstance.getWidthInBlocks() - 1;
	}

	public int getRandHeight() 
	{
		int x = (3 * worldObj.mcInstance.getHeightInBlocks()) / 4;
		int rand = new Random().nextInt(x);
		if(rand <= 0) rand = 1;
		return rand;
	}
}
