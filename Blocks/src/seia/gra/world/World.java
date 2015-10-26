package seia.gra.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.MainClass;
import seia.gra.api.block.IBlockMovable;
import seia.gra.api.world.IWorld;
import seia.gra.api.world.IWorldRenderer;
import seia.gra.api.world.WorldRegistry;
import seia.gra.block.Block;
import seia.gra.block.movable.BlockClonePlayer;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.BlockMovable;
import seia.gra.block.movable.player.BlockPlayer;
import seia.gra.block.movable.player.IPlayer;
import seia.gra.block.nonmovable.BlockNextLevel;
import seia.gra.file.FilesHandler;
import seia.gra.world.worldelement.WorldElementAvailableHits;
import seia.gra.world.worldelement.WorldElementLevelValue;
import seia.gra.world.worldelement.WorldElementNick;
import seia.gra.world.worldrenderer.WorldRenderer;
import seia.gra.world.worldrenderer.WorldRendererClonePlayer;
import seia.gra.world.worldrenderer.WorldRendererSquareBasic;

public class World implements IWorld
{
	/**
	 * TODO: Swiat mozna przerobic na liste list -  List<List<Block>>
	 * Wtedy moglby sie rozszerzac.
	 * Jednak trzebaby przerobic wymiary swiata oraz przesowanie ekranu za graczem.
	 */
	public WorldRenderer currentRenderer;
	private int SZER, WYS;
	boolean b1;
	public BlockPlayer player;
	public BlockNextLevel nextLevel;
	public MainClass mcInstance;
	public List<IBlockMovable> currentTiles;
	public WorldRegistry registry = WorldRegistry.INSTANCE;
	
	public World(MainClass main)
	{
		SZER = main.SZER;
		WYS = main.WYS;
		b1 = main.setHeart;
		mcInstance = main;
		player = new BlockPlayer(1, 1, this);
		nextLevel = new BlockNextLevel(player.getWidth(), player.getRandHeight(), this);
		addElements();
		addRenderers();
		setNick(main.nick);
		setAvailableHits();
		{
			int x = new Random().nextInt(registry.getWorldRenderers().size() - 1);
			currentRenderer = (WorldRenderer) registry.getWorldRenderers().get(x);
		}
		currentTiles = currentRenderer.getMovableBlocksOnMap();
	}
	
	public void reloadPanel()
	{
		setCurrentRendererRandom();
		player.X = 1;
		player.Y = new Random().nextInt(mcInstance.getHeightInBlocks() - 2) + 1;
		nextLevel.X = nextLevel.getWidth();
		nextLevel.Y = nextLevel.getRandHeight();
		currentTiles.clear();
		currentTiles = currentRenderer.getMovableBlocksOnMap();
	}
	
	public void killEnemy(BlockEnemy enemyToKill)
	{
		for(int i = 0; i < currentTiles.size(); i++)
		{
			if(currentTiles.get(i) instanceof BlockEnemy)
			{
				BlockEnemy enemy = (BlockEnemy) currentTiles.get(i);
				if((enemy.X == enemyToKill.X) && (enemy.Y == enemyToKill.Y))
				{
					currentTiles.remove(i);
					return;
				}
			}
		}
	}
	
	public void killCurrentPlayer()
	{
		player = null;
		findNextPlayerOnMap();
	}
	
	public void findNextPlayerOnMap()
	{
		for(int i = 0; i < currentTiles.size(); i++)
			if(currentTiles.get(i) instanceof BlockClonePlayer)
			{
				BlockClonePlayer clone = (BlockClonePlayer) currentTiles.get(i);
				player = new BlockPlayer(clone.X - 1, clone.Y, this);
				killEnemy(clone);
				return;
			}
	}
	
	public void decreaseAfterHit()
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)registry.getWorldElements().get(i)).availableHits--;
				return;
			}
		}
	}
	
	public void decreaseAfterHit(int ile)
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)registry.getWorldElements().get(i)).availableHits -= ile;
				return;
			}
		}
	}
	
	public void setAvailableHits()
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				try
				{
					((WorldElementAvailableHits)registry.getWorldElements().get(i)).availableHits = FilesHandler.CONFIG.avaiableHits; //FileConfig.avaiableHits;
					return;
				}
				catch(Exception e)
				{
					((WorldElementAvailableHits)registry.getWorldElements().get(i)).availableHits = 10;
					return;
				}
			}
		}
	}
	
	public void setNick(String nick)
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementNick.class.getName()))
			{
				((WorldElementNick)registry.getWorldElements().get(i)).nick = nick;
				return;
			}
		}
	}
	
	public void updateLevelValue() 
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)registry.getWorldElements().get(i)).level++;
				return;
			}
		}
	}
	
	public void updateLevelValue(int level) 
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)registry.getWorldElements().get(i)).level = level;
				return;
			}
		}
	}
	
	public int getCurrentLevelValue()
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
				return ((WorldElementLevelValue)registry.getWorldElements().get(i)).level;
		return -1;
	}

	public boolean addElements()
	{
		try 
		{
			WorldElementLevelValue levelValue = new WorldElementLevelValue((Block.BLOCK_SIZE / 4), (Block.BLOCK_SIZE / 2));
			registry.addWorldElement(levelValue);
			
			//WorldElementNick nick = new WorldElementNick((SZER / 4), (Block.BLOCK_SIZE / 2));
			//worldElement.add(nick);
			
			WorldElementAvailableHits hits = new WorldElementAvailableHits((SZER / 2), (Block.BLOCK_SIZE / 2));
			registry.addWorldElement(hits);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addRenderers()
	{
		try
		{
			WorldRendererSquareBasic square = new WorldRendererSquareBasic(SZER, WYS, this);
			registry.addWorldRenderer(square);
			
			WorldRendererClonePlayer clone = new WorldRendererClonePlayer(SZER, WYS, this);
			registry.addWorldRenderer(clone);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < registry.getWorldRenderers().size(); i++)
			if(registry.getWorldRenderers().get(i).getRendererID() == currentRenderer.getRendererID())
				registry.getWorldRenderers().get(i).paintWorld(g);
		for(int i = 0; i < registry.getWorldElements().size(); i++)
			registry.getWorldElements().get(i).paintComponent(g);
		for(int  i = 0; i < currentTiles.size(); i++)
			if(currentTiles.get(i) != null)
				currentTiles.get(i).paintComponent(g);
		nextLevel.paintComponent(g);
		player.paintComponent(g);
	}
	
	public World setCurrentRenderer(IWorldRenderer renderer)
	{
		currentRenderer = (WorldRenderer) renderer;
		return this;
	}
	
	public boolean setCurrentRendererRandom()
	{
		int rand = new Random().nextInt(registry.getWorldRenderers().size()) - 1;
		if(rand < 0) rand = 0;
		currentRenderer = (WorldRenderer) registry.getWorldRenderers().get(rand);
		if(currentRenderer.getRendererID() == registry.getWorldRenderers().get(rand).getRendererID()) 
			return true;
		return false;
	}
	
	public BlockPlayer getPlayer()
	{
		for(int i = 0; i < Block.blocksInGame.size(); i++)
			if(Block.blocksInGame.get(i) instanceof BlockPlayer)
				return (BlockPlayer) Block.blocksInGame.get(i);
		return null;
	}
	
	public BlockNextLevel getNextLevel()
	{
		for(int i = 0; i < Block.blocksInGame.size(); i++)
			if(Block.blocksInGame.get(i) instanceof BlockNextLevel)
				return (BlockNextLevel) Block.blocksInGame.get(i);
		return null;
	}
	
	public List<BlockClonePlayer> getPlayerClonesInWorld()
	{
		List<BlockClonePlayer> clones = new ArrayList<BlockClonePlayer>();
		for(int i = 0; i < currentTiles.size(); i++)
			if(currentTiles.get(i) instanceof BlockClonePlayer)
				clones.add((BlockClonePlayer) currentTiles.get(i));
		return clones;
	}
	
	public int countPlayerClones()
	{
		return getPlayerClonesInWorld().size();
	}
	
	public boolean arePlayerClonesOnWorld()
	{
		if(countPlayerClones() > 0)
			return true;
		return false;
	}

	public void addAvaiableHits(int hitsToAdd) 
	{
		for(int i = 0; i < registry.getWorldElements().size(); i++)
		{
			if(registry.getWorldElements().get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				WorldElementAvailableHits weah = (WorldElementAvailableHits) registry.getWorldElements().get(i);
				weah.availableHits += hitsToAdd;
				return;
			}
		}
	}
	
	public boolean areAllPlayerGone()
	{
		for(int i = 0; i < currentTiles.size(); i++)
			if(currentTiles.get(i) instanceof IPlayer)
				return false;
		return true;
	}
	
	/**
	 * Dodawanie randomowego klocka do planszy.
	 */
	public void addEnemy()
	{
		boolean canAdd = true;
		int posX, posY;
		do
		{
			canAdd = true;
			posX = new Random().nextInt(mcInstance.getWidthInBlocks() - 1);
			if(posX == 0) posX = 2;
			posY = new Random().nextInt(mcInstance.getHeightInBlocks() - 1);
			if(posY == 0) posY = 2;
			for(int i = 0; i < currentTiles.size(); i++)
			{
				if(currentTiles.get(i) instanceof BlockEnemy)
				{
					BlockEnemy enemy = (BlockEnemy)currentTiles.get(i);
					if((enemy.X == posX) && (enemy.Y == posY))
					{
						canAdd = false;
					}
				}
			}
		}while(!canAdd);
		if(canAdd)
		{
			BlockEnemy newEnemy = new BlockEnemy(posX, posY, this);
			currentTiles.add(newEnemy);
		}
	}

	public boolean isPlaceToAddEnemy() 
	{
		BlockMovable[][] movTab = getMovableBlocksOnMap();
		for(int i = 1; i < movTab.length; i++)
			for(int j = 1; j < movTab.length; j++)
				if((movTab[i][j] == null) &&
						(i != 0) &&
						(j != 0) &&
						(i != movTab.length - 1) &&
						(j != movTab.length - 1))
					return true;
		return false;
	}
	
	public int[] getFirstPlaceToAddEnemy()
	{
		BlockMovable[][] movTab = getMovableBlocksOnMap();
		for(int i = 1; i < movTab.length; i++)
			for(int j = 1; j < movTab.length; j++)
				if((movTab[i][j] == null) &&
						(i != 0) &&
						(j != 0) &&
						(i != movTab.length - 1) &&
						(j != movTab.length - 1))
				{
					int[] coords = new int[2]; //x, y
					coords[0] = i;
					coords[1] = j;
					return coords;
				}
		return null;
	}
	
	public BlockMovable[][] getMovableBlocksOnMap()
	{
		return currentRenderer.getMovableBlocksOnMap(currentTiles);
	}
	
	public int getSizeXInBlocks()
	{
		return SZER / Block.BLOCK_SIZE;
	}
	
	public int getSizeYInBlocks()
	{
		return WYS / Block.BLOCK_SIZE;
	}
}
