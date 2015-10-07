package seia.gra.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.MainClass;
import seia.gra.block.Block;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.BlockMovable;
import seia.gra.block.movable.player.BlockPlayer;
import seia.gra.block.nonmovable.BlockNextLevel;
import seia.gra.file.FilesHandler;
import seia.gra.world.renderer.WorldRenderer;
import seia.gra.world.renderer.WorldRendererClonePlayer;
import seia.gra.world.renderer.WorldRendererHeart;
import seia.gra.world.renderer.WorldRendererSquareBasic;
import seia.gra.world.worldelement.WorldElement;
import seia.gra.world.worldelement.WorldElementAvailableHits;
import seia.gra.world.worldelement.WorldElementLevelValue;
import seia.gra.world.worldelement.WorldElementNick;

public class World 
{
	/**
	 * TODO: Swiat mozna przerobic na liste list -  List<List<Block>>
	 * Wtedy moglby sie rozszerzac.
	 * Jednak trzebaby przerobic wymiary swiata oraz przesowanie ekranu za graczem.
	 */
	public List<WorldElement> worldElement = new ArrayList<WorldElement>();
	public List<WorldRenderer> worldRenderer = new ArrayList<WorldRenderer>();
	public WorldRenderer currentRenderer;
	private int SZER, WYS;
	boolean b1;
	public BlockPlayer player;
	public BlockNextLevel nextLevel;
	public MainClass mcInstance;
	public List<BlockMovable> currentTiles;
	
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
			int x = new Random().nextInt(worldRenderer.size() - 1);
			currentRenderer = worldRenderer.get(x);
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
	
	public void decreaseAfterHit()
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)worldElement.get(i)).availableHits--;
				return;
			}
		}
	}
	
	public void decreaseAfterHit(int ile)
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)worldElement.get(i)).availableHits -= ile;
				return;
			}
		}
	}
	
	public void setAvailableHits()
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				try
				{
					((WorldElementAvailableHits)worldElement.get(i)).availableHits = FilesHandler.CONFIG.avaiableHits; //FileConfig.avaiableHits;
					return;
				}
				catch(Exception e)
				{
					((WorldElementAvailableHits)worldElement.get(i)).availableHits = 10;
					return;
				}
			}
		}
	}
	
	public void setNick(String nick)
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementNick.class.getName()))
			{
				((WorldElementNick)worldElement.get(i)).nick = nick;
				return;
			}
		}
	}
	
	public void updateLevelValue() 
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)worldElement.get(i)).level++;
				return;
			}
		}
	}
	
	public void updateLevelValue(int level) 
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)worldElement.get(i)).level = level;
				return;
			}
		}
	}
	
	public int getCurrentLevelValue()
	{
		for(int i = 0; i < worldElement.size(); i++)
			if(worldElement.get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
				return ((WorldElementLevelValue)worldElement.get(i)).level;
		return -1;
	}

	public boolean addElements()
	{
		try 
		{
			WorldElementLevelValue levelValue = new WorldElementLevelValue(13, 25);
			worldElement.add(levelValue);
			
			WorldElementNick nick = new WorldElementNick(200, 25);
			worldElement.add(nick);
			
			WorldElementAvailableHits hits = new WorldElementAvailableHits(400, 25);
			worldElement.add(hits);
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
			worldRenderer.add(square);
			
			WorldRendererClonePlayer clone = new WorldRendererClonePlayer(SZER, WYS, this);
			worldRenderer.add(clone);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public World addWorldRenderer(Class<? extends WorldRenderer> clazz, int szer, int wys, World world)
	{
		try 
		{
			worldRenderer.add(clazz.newInstance());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return this;
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i = 0; i < worldRenderer.size(); i++)
			if(worldRenderer.get(i).getRendererID() == currentRenderer.getRendererID())
				worldRenderer.get(i).paintWorld(g);
		for(int i = 0; i < worldElement.size(); i++)
			worldElement.get(i).paintComponent(g);
		for(int  i = 0; i < currentTiles.size(); i++)
			if(currentTiles.get(i) != null)
				currentTiles.get(i).paintComponent(g);
		nextLevel.paintComponent(g);
		player.paintComponent(g);
	}
	
	public World setCurrentRenderer(WorldRenderer renderer)
	{
		currentRenderer = renderer;
		return this;
	}
	
	public boolean setCurrentRendererRandom()
	{
		int rand = new Random().nextInt(worldRenderer.size()) - 1;
		if(rand < 0) rand = 0;
		currentRenderer = worldRenderer.get(rand);
		if(currentRenderer.getRendererID() == worldRenderer.get(rand).getRendererID()) 
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

	public void addAvaiableHits(int hitsToAdd) 
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				WorldElementAvailableHits weah = (WorldElementAvailableHits) worldElement.get(i);
				weah.availableHits += Math.abs(hitsToAdd);
				return;
			}
		}
	}
}
