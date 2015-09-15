package seia.gra.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seia.gra.MainClass;
import seia.gra.block.Block;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.player.BlockPlayer;
import seia.gra.block.nonmovable.BlockNextLevel;
import seia.gra.file.FileConfig;
import seia.gra.world.renderer.WorldRenderer;
import seia.gra.world.renderer.WorldRendererHeart;
import seia.gra.world.renderer.WorldRendererSquare;
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
	private static int SZER, WYS;
	boolean b1;
	public BlockPlayer player;
	public List<BlockEnemy> enemy = new ArrayList<BlockEnemy>();
	public BlockNextLevel nextLevel;
	public MainClass mcInstance;
	
	public World(int szer, int wys, boolean b1, String nick, MainClass main)
	{
		SZER = szer;
		WYS = wys;
		this.b1 = b1;
		mcInstance = main;
		player = new BlockPlayer(1, 1, this);
		nextLevel = new BlockNextLevel(BlockNextLevel.getWidth(), BlockNextLevel.getRandHeight(), this);
		if(b1)
		{
			losEnemy(0);
		}
		else
		{
			losEnemy(90);//new Random().nextInt(95);
		}
		addElements();
		addRenderers();
		setNick(nick);
		setAvailableHits();
		if(b1)
			currentRenderer = worldRenderer.get(1);
		else
			currentRenderer = worldRenderer.get(0);
	}
	
	public void reloadPanel() 
	{
		setCurrentRendererRandom();
		player.X = 1;
		player.Y = new Random().nextInt(MainClass.getHeightInBlocks() - 2) + 1;
		nextLevel.X = BlockNextLevel.getWidth();
		nextLevel.Y = BlockNextLevel.getRandHeight();
		enemy.clear();
		losEnemy(90); //new Random().nextInt(95);
	}
	
	public boolean isEnemyAtCoords(int x, int y)
	{
		for(int i = 0; i < enemy.size(); i++)
			if((enemy.get(i).X == x) && (enemy.get(i).Y == y))
				return true;
		return false;
	}
	
	public void killEnemy(BlockEnemy enemyToKill)
	{
		for(int i = 0; i < enemy.size(); i++)
		{
			if((enemy.get(i).X == enemyToKill.X) && (enemy.get(i).Y == enemyToKill.Y))
			{
				enemy.remove(i);
				return;
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
	
	public void setAvailableHits()
	{
		for(int i = 0; i < worldElement.size(); i++)
		{
			if(worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				try
				{
					((WorldElementAvailableHits)worldElement.get(i)).availableHits = FileConfig.avaiableHits;
					return;
				}
				catch(Exception e)
				{
					((WorldElementAvailableHits)worldElement.get(i)).availableHits = 3;
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

	public void losEnemy(int ile)
	{
		for(int i = 0; i < ile; i++)
		{
			addEnemy();
		}
	}
	
	public boolean addEnemy() 
	{
		int rX = new Random().nextInt(SZER / Block.BLOCK_SIZE);
		int rY = new Random().nextInt(WYS / Block.BLOCK_SIZE);
		if((rX != 1) 
				&& (rY != 1) 
				&& (rX != 0) 
				&& (rY != 0) 
				&& (rX != MainClass.getWidthInBlocks() - 1) 
				&& (rY != MainClass.getHeightInBlocks() - 1))
		{
			enemy.add(new BlockEnemy(rX, rY, this));
			return true;
		}
		else
		{
			addEnemy();
		}
		return false;
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
			WorldRendererSquare square = new WorldRendererSquare(SZER, WYS, this);
			worldRenderer.add(square);
			if(b1)
			{
				WorldRendererHeart wrh = new WorldRendererHeart(SZER, WYS, this);
				worldRenderer.add(wrh);
			}
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
		for(int i = 0; i < worldRenderer.size(); i++)
			if(worldRenderer.get(i).getRendererID() == currentRenderer.getRendererID())
				worldRenderer.get(i).paintWorld(g);
		for(int i = 0; i < worldElement.size(); i++)
			worldElement.get(i).paintComponent(g);
		for(int  i = 0; i < enemy.size(); i++)
		{
			enemy.get(i).paintComponent(g);
		}
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
				weah.availableHits++;
				return;
			}
		}
	}
}
