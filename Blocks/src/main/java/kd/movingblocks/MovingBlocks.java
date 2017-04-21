package main.java.kd.movingblocks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.kd.movingblocks.camera.Camera;
import main.java.kd.movingblocks.entity.EntityPlayer;
import main.java.kd.movingblocks.event.EventFactory;
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
	 * Single, global instance of the MovingBlocks
	 */
	public static final MovingBlocks INSTANCE = new MovingBlocks();
	
	/**
	 * Indicates if game is running
	 */
	private boolean _running = false;
	/**
	 * Main game window.
	 * May be NULL !!!!!
	 */
	private Window _window;
	/**
	 * Canvas into which everything should be drawn. (mainly for taking graphics object)
	 */
	private Canvas _canvas;
	/**
	 * Moving Blocks key listener
	 */
	private KeyListener _keyListener;
	/**
	 * Moving Blocks mouse listener
	 */
	private IMouseListener _mouseListener;
	/**
	 * Nick of the Player who is currently playing
	 */
	private String _nick;
	/**
	 * Current World
	 */
	private World _world;
	/**
	 * Player itself
	 */
	private EntityPlayer _player;
	/**
	 * Graphics used for rendering stuff
	 */
	private Graphics _graphics;
	/**
	 * MovingBlocks logger.
	 */
	private Logger _logger;
	/**
	 * Ticks
	 */
	private int _ticksInternal = 0;
	/**
	 * Used for outside ticks showing.
	 */
	private int _ticks;
	/**
	 * Frames
	 */
	private int _framesInternal = 0;
	/**
	 * Used for outside FPS showing.
	 */
	private int _fps = 0;
	
	private MovingBlocks()
	{
		try
		{
			this._logger = Logger.getLogger("MovingBlocks");
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
	 * Sets the game Window. May be NULL !!!!
	 * 
	 * @param window
	 */
	public void setGameWindow(Window window)
	{
		this._window = window;
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
		if (this._keyListener == null) this._keyListener = new MovingBlocksKeyListener();
		return this._keyListener;
	}
	
	/**
	 * @return Returns the MouseListener for this MovingBlocks instance.
	 */
	public IMouseListener getMouseListener()
	{
		if (this._mouseListener == null) this._mouseListener = new MovingBlocksMouseListener();
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
	 * @return Returns TRUE if MovingBlocks is running, otherwise FALSE.
	 */
	public boolean isRunning()
	{
		return this._running;
	}
	
	/**
	 * Indicates what should happen when MovingBlocks starts for the first time.
	 */
	public void start()
	{
		_running = true;
	}
	
	/**
	 * Add new message using MovingBlocks logger.
	 * 
	 * @param logLevel Level of the logging message.
	 * @param logMessage Message itself.
	 */
	public void log(Level logLevel, String logMessage)
	{
		this._logger.log(logLevel, logMessage);
	}
	
	/**
	 * @return Returns the number of Ticks.
	 */
	public int getTicks()
	{
		return this._ticks;
	}
	
	/**
	 * @return Returns the number of FPS's.
	 */
	public int getFPS()
	{
		return this._fps;
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
		
		while (_running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) 
			{
				tick();
				this._ticksInternal++;
				delta--;
			}
			render();
			this._framesInternal++;
			if (System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
//				log(Level.INFO, this._ticks + " ticks, " + this._frames + " fps");
				this._fps = this._framesInternal;
				this._ticks = this._ticksInternal;
				this._framesInternal = 0;
				this._ticksInternal = 0;
			}
		}
	}
	
	/**
	 * What should happen in each game tick. (Server-side operations)
	 */
	private void tick()
	{
		EventFactory.INSTANCE.processEvents();
	}
	
	/**
	 * Each render tick. (Client-side operations)
	 */
	private void render()
	{
		if (this._canvas == null) return; // If Canvas is null return - nowhere to paint in
		
		BufferStrategy bs = this._canvas.getBufferStrategy();
		if (bs == null) 
		{
			this._canvas.createBufferStrategy(3);
			return;
		}
		this._graphics = bs.getDrawGraphics();
		renderStuff();
		
		// Free resource after rendering
		this._graphics.dispose();
		bs.show();
	}
	
	/**
	 * Render stuff here
	 */
	private void renderStuff()
	{
		// Render Player
		if (this._world.getDimensionId() == this._player.getWorld().getDimensionId())
		{
			_world.render(this._graphics);
			MovingBlocks.INSTANCE.getPlayer().renderEntity(this._graphics);
		}
		else
		{
			this._world = this._player.getWorld();
			_world.render(this._graphics);
			MovingBlocks.INSTANCE.getPlayer().renderEntity(this._graphics);
		}
		// Rendering 2D screen elements for Player.
		Camera.INSTANCE.renderScreen(this._graphics);
	}
	
	/**
	 * Method used for closing the game.
	 */
	public void close()
	{
		if (this._window != null) 
			this._window.dispose();
	}
}