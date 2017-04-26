package main.java.kd.movingblocks;

import java.awt.Canvas;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Moving Blocks Main Frame.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocksCanvas extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1920799881438758881L;
	
	/**
	 * Frame itself.
	 */
	private JFrame _frame;
	/**
	 * Main game thread.
	 */
	private Thread _gameThread;
	
	public MovingBlocksCanvas()
	{
		String nick = "";
		try
		{
			nick = JOptionPane.showInputDialog(null, "Podaj nick:", "Moving Blocks !!! " + Data.VERSION, JOptionPane.YES_OPTION);
			if (nick.equals(""))
			{
				nick = "Tester #" + new Random().nextInt();
			}
		}
		catch(Exception e)
		{
			nick = "Tester #" + new Random().nextInt();
		}
		
		MovingBlocks.INSTANCE.setNick(nick);
		
		this.addKeyListener(MovingBlocks.INSTANCE.getKeyListener());
		this.addMouseListener(MovingBlocks.INSTANCE.getMouseListener());
		this.addMouseMotionListener(MovingBlocks.INSTANCE.getMouseListener());
		this.addMouseWheelListener(MovingBlocks.INSTANCE.getMouseListener());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void run() 
	{
		init();
		MovingBlocks.INSTANCE.setGameCanvas(this);
		MovingBlocks.INSTANCE.setGameWindow(this._frame);
		MovingBlocks.INSTANCE.run();
	}
	
	/**
	 * Initialize Frame
	 */
	private void init()
	{
		_frame = new JFrame("MovingBlocks !!!" + " Player: " + MovingBlocks.INSTANCE.getNick());
		_frame.setSize(Settings.FRAME_WIDTH, Settings.FRAME_HEIGHT);
		_frame.setResizable(false);
		_frame.add(this);
		_frame.pack();
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setLocationRelativeTo(null);
		_frame.setVisible(true);
	}
	
	/**
	 * Start game.
	 */
	public void start()
	{
		MovingBlocks.INSTANCE.start();
		_gameThread = new Thread(this, "MovingBlocks Canvas Thread");
		_gameThread.start();
		this.setPreferredSize(Settings.CANVAS_DIM);
	}
	
	/**
	 * Program main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// Create new frame object
		MovingBlocksCanvas frame = new MovingBlocksCanvas();
		// Start frame
		frame.start();
	}
}