package main.java.kd.movingblocks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;

import main.java.kd.movingblocks.entity.player.EntityPlayer;
import main.java.kd.movingblocks.listener.IMouseListener;
import main.java.kd.movingblocks.listener.MovingBlocksKeyListener;
import main.java.kd.movingblocks.listener.MovingBlocksMouseListener;
import main.java.kd.movingblocks.world.DimensionManager;
import main.java.kd.movingblocks.world.World;
import main.java.kd.movingblocks.world.renderer.WorldRendererOverworld;

/**
 * Root class of the MovingBlocks.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocks
{
	/**
	 * Single, global instance of the MovingBlocks.
	 */
	public static final MovingBlocks INSTANCE = new MovingBlocks();
	
	/**
	 * Indicates if game is running.
	 */
	private boolean _running = false;
	/**
	 * Canvas into which everything should be drawn. (mainly for taking graphics object)
	 */
	private Canvas _canvas;
	/**
	 * Moving Blocks key listener.
	 */
	private KeyListener _keyListener;
	/**
	 * Moving Blocks mouse listener;
	 */
	private IMouseListener _mouseListener;
	/**
	 * Nick of the Player who is currently playing.
	 */
	private String _nick;
	/**
	 * Current World
	 */
	private World _world;
	/**
	 * Player itself.
	 */
	private EntityPlayer _player;
	
	private MovingBlocks()
	{
		try
		{
			this._world = DimensionManager.createNewWorld(0, WorldRendererOverworld.class);
			
			this._player = new EntityPlayer();
			this._player.setPosition(1, 1);
			this._player.setWorld(this._world);
		}
		catch(Exception e)
		{
			Data.log(Level.WARNING, "Critical error while creating Overworld !!!");
		}
	}
	
	/**
	 * Set the game Canvas. Use it to tell game where to draw graphics.
	 * 
	 * @param canvas
	 */
	public void setGameCanvas(Canvas canvas)
	{
		this._canvas = canvas;
	}
	
	/**
	 * Sets Players nick.
	 * 
	 * @param nick
	 */
	public void setNick(String nick)
	{
		this._nick = nick;
	}
	
	/**
	 * @return Returns the nick of the Player who is currently playing.
	 */
	public String getNick()
	{
		return this._nick;
	}
	
	/**
	 * @return Returns the KeyListener for this MovingBlocks instance.
	 */
	public KeyListener getKeyListener()
	{
		if(this._keyListener == null) this._keyListener = new MovingBlocksKeyListener();
		return this._keyListener;
	}
	
	public IMouseListener getMouseListener()
	{
		if(this._mouseListener == null) this._mouseListener = new MovingBlocksMouseListener();
		return this._mouseListener;
	}
	
	/**
	 * @return Returns the currently loaded World.
	 */
	public World getWorld()
	{
		return this._world;
	}
	
	/**
	 * @return Return the Player.
	 */
	public EntityPlayer getPlayer()
	{
		return this._player;
	}
	
	/**
	 * Indicates what should happen when MovingBlocks starts for the first time.
	 */
	public void start()
	{
		_running = true;
	}
	
	/**
	 * Main game loop.
	 */
	public void run()
	{
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / Settings.TPS;
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		while(_running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) 
			{
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	/**
	 * What should happen in each game tick. (Server-side operations)
	 */
	private void tick()
	{
	}
	
	/**
	 * Each render tick. (Client-side operations)
	 */
	private void render()
	{
		if(this._canvas == null) return; // If Canvas is null return - nowhere to paint in
		
		BufferStrategy bs = this._canvas.getBufferStrategy();
		if(bs == null) 
		{
			this._canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		// Redner stuff here
		{
			// Render Player
			if(this._world.getDimensionId() == this._player.getWorld().getDimensionId())
			{
				_world.render(g);
				MovingBlocks.INSTANCE.getPlayer().renderEntity(g);
			}
			else
			{
				this._world = this._player.getWorld();
				_world.render(g);
				MovingBlocks.INSTANCE.getPlayer().renderEntity(g);
			}
		}
		
		// Free resource after rendering
		g.dispose();
		bs.show();
	}
}