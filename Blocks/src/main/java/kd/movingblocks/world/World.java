package main.java.kd.movingblocks.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.kd.movingblocks.Settings;
import main.java.kd.movingblocks.block.Block;
import main.java.kd.movingblocks.block.Blocks;
import main.java.kd.movingblocks.entity.EntityEnemy;
import main.java.kd.movingblocks.entity.EntityNextLevelTeleport;
import main.java.kd.movingblocks.util.BlockData;
import main.java.kd.movingblocks.util.BlockPos;
import main.java.kd.movingblocks.world.renderer.WorldRenderer;

/**
 * Main World class
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class World 
{
	/**
	 * Dimension id of this World
	 */
	private final int _dimId;
	/**
	 * Renderer of the current World
	 */
	private final WorldRenderer _renderer;
	/**
	 * Contains data about all blocks in this World
	 */
	private final BlockData[] _blockData;
	/**
	 * List containing information about all enemies on this World
	 */
	private final List<EntityEnemy> _enemies = new ArrayList<>();
	/**
	 * Teleporter used for teleporting Player to next level
	 */
	private final EntityNextLevelTeleport _entityTeleport = new EntityNextLevelTeleport();
	
	public World(int dimId, WorldRenderer renderer)
	{
		this._dimId = dimId;
		this._renderer = renderer;
		this._blockData = new BlockData[Settings.BLOCKS_IN_ROW * Settings.BLOCKS_IN_ROW];
		// Set random teleporter position
		this._entityTeleport.reloadPosition();
		
		setWorldBlocks();
	}
	
	/**
	 * Sets the Blocks on World.
	 * ( Maybe used to reset World ??? )
	 */
	private void setWorldBlocks()
	{
		// Create World
		for (int x = 0; x < Settings.BLOCKS_IN_ROW; ++x) 
			for (int y = 0; y < Settings.BLOCKS_IN_ROW; ++y) 
			{
				if (x == 0 || // Left
						y == 0 || // Top
						x == Settings.BLOCKS_IN_ROW - 1 || // Right
						y == Settings.BLOCKS_IN_ROW - 1) // Bottom
					this._blockData[y * Settings.BLOCKS_IN_ROW + x] = new BlockData(new BlockPos(x, y), Blocks.VOID); // Border of the World
				else
					this._blockData[y * Settings.BLOCKS_IN_ROW + x] = new BlockData(new BlockPos(x, y), Blocks.DIRT); // Other Blocks
			}
		
		// Spawn Enemies
		for (int i = 0; i < Settings.Enemy.BASE_NUMBER_ON_WORLD; ++i)
		{
			addNewEnemy();
		}
	}
	
	/**
	 * Add new Enemy to this World.
	 */
	public void addNewEnemy()
	{
		// Randomize Enemy position
		Random rand = new Random();
		int randX = rand.nextInt(Settings.BLOCKS_IN_ROW - 2) + 1;
		int randY = rand.nextInt(Settings.BLOCKS_IN_ROW - 2) + 1;
		
		// Add Entity
		EntityEnemy ee = new EntityEnemy();
		ee.setPosition(randX, randY);
		this._enemies.add(ee);	
	}
	
	/**
	 * @return Returns the Id of this dimension.
	 */
	public int getDimensionId()
	{
		return this._dimId;
	}
	
	/**
	 * @return Returns renderer of the current world.
	 */
	public WorldRenderer getRenderer()
	{
		return this._renderer;
	}
	
	/**
	 * Main render method for rendering what is on World.
	 * 
	 * @param g
	 */
	public void render(Graphics g) 
	{
		this._renderer.renderWorld(g);
	}
	
	/**
	 * @param pos
	 * 
	 * @return Returns the position on BlockData list.
	 */
	private int countPos(BlockPos pos)
	{
		return pos.getY() * Settings.BLOCKS_IN_ROW + pos.getX();
	}
	
	/**
	 * Returns block at specified position.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Block getBlock(BlockPos pos) 
	{
		return this._blockData[countPos(pos)].getBlock();
	}
	
	/**
	 * Sets new Block on specified position.
	 * 
	 * @param pos
	 * @param block
	 */
	public void setBlock(BlockPos pos, Block block)
	{
		this._blockData[countPos(pos)].setBlock(block);
	}
	
	/**
	 * @return Returns list of all enemies on this World.
	 */
	public List<EntityEnemy> getEnemies()
	{
		return this._enemies;
	}
	
	/**
	 * @return Returns the ENtity connected with teleporting Player to next level.
	 */
	public EntityNextLevelTeleport getTeleport()
	{
		return this._entityTeleport;
	}
	
	public String toString()
	{
		return "World[dimId=" + this._dimId + "]";
	}
}