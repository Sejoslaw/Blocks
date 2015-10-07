package seia.gra.block.movable;

import java.awt.Color;

import seia.gra.block.Block;
import seia.gra.block.movable.player.BlockPlayer;
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
		for(int x = 0; x < Block.blocksInGame.size(); x++)
			if(Block.blocksInGame.get(x) instanceof BlockPlayer)
				return Block.blocksInGame.get(x).getColor();
		return null;
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
