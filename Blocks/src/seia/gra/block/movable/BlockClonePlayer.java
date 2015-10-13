package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.api.block.Block;
import seia.gra.block.movable.player.IPlayer;
import seia.gra.world.World;

public class BlockClonePlayer extends BlockEnemy implements IPlayer
{
	public BlockClonePlayer(Color c, int x, int y, World world) 
	{
		super(Block.getPlayerColor(), x, y, world);
	}
	
	@Override
	public Color getColor()
	{
		return Block.getPlayerColor();
	}
	
	@Override
	public boolean isPlayer() 
	{
		return false;
	}
	
	@Override
	public boolean isPlayerClone()
	{
		return true;
	}
}
