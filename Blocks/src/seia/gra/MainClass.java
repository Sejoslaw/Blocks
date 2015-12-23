package seia.gra;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import seia.gra.api.IMainClass;
import seia.gra.api.world.IWorld;
import seia.gra.block.Block;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.event.EventCheckCollisionWithEnemy;
import seia.gra.event.EventCheckForNextLevel;
import seia.gra.file.FilesHandler;
import seia.gra.utils.Key;
import seia.gra.world.World;
import seia.gra.world.worldrenderer.WorldRendererHeart;

/**
 * Pomysly:
 * -Manu
 * -W menu dorobic konstruktor poziomow (+ sterowanie)
 * 		(klikniecie -> Postaw klocek, 
 * 		 klikniecie -> Ustaw kolor, 
 * 		 klikniecie -> Zakoncz)
 * 		 ->>> Eksport stworzonego swiata do pliku
 * -W menu -> Tablica Wynikow
 * 
 * 
 * @author Krzysztof Dobrzynski
 */
public class MainClass extends Canvas implements Runnable, ActionListener, KeyListener, IMainClass
{
	private static final long serialVersionUID = -3273319500205136710L;
	public static final int SZER = 800;
	public static final int WYS = 600;
	public static final int TICKS_PER_SECOND = 60;
	private static final String VERSION = "v0.0.11";
	
	private boolean running = false;
	public JFrame frame;
	public Thread mainThread;
	public World worldObj;
	public boolean setHeart;
	public String nick;
	
	public MainClass(boolean setHeart, String nick)
	{
		this.setHeart = setHeart;
		this.nick = nick;
		FilesHandler.CONFIG.checkConfig(this); //FileConfig.checkConfig(this);
		worldObj = new World(this);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(SZER, WYS));
	}
	
	public void start()
	{
		running = true;
		mainThread = new Thread(this);
		mainThread.start();
	}
	
	private void init()
	{
		frame = new JFrame("GoRight !!!");
		frame.setSize(SZER, WYS);
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void run()
	{
		init();
		
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / TICKS_PER_SECOND;
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		while (running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) 
			{
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick()
	{
	}
	
	private void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) 
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		worldObj.paintComponent(g);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) 
	{
		boolean b1 = false;
		String s1;
		try
		{
			s1 = JOptionPane.showInputDialog(null, "Podaj nick:", "GoRight !!! " + VERSION, JOptionPane.YES_OPTION);
			if(s1.toLowerCase().equals(WorldRendererHeart.input.toLowerCase()))
			{
				b1 = true;
			}
			if(s1.toLowerCase().equals(""))
			{
				s1 = "Tester #" + new Random().nextInt();
			}
		}
		catch(Exception e)
		{
			s1 = "Tester #" + new Random().nextInt();
		}
		
		MainClass mc = new MainClass(b1, s1);
		mc.start();
	}
	
	public void newGame()
	{
		JOptionPane.showMessageDialog(this,"Game Over :(", "gAME oVER", JOptionPane.YES_OPTION);
		//FilesHandler.HIGHSCORE.reloadHighscore(this); //TODO
		FilesHandler.CONFIG.checkConfig(this);
		worldObj.reloadPanel();
		worldObj.updateLevelValue(1);
		worldObj.setAvailableHits();
	}
	
	public boolean getSetHeart()
	{
		return setHeart;
	}
	
	public int getSZER()
	{
		return SZER;
	}
	
	public int getWYS()
	{
		return WYS;
	}
	
	public String getNick()
	{
		return nick;
	}
	
	public IWorld getWorldObj()
	{
		return worldObj;
	}
	
	public int getWidthInBlocks()
	{
		return SZER / Block.BLOCK_SIZE;
	}
	
	public int getHeightInBlocks()
	{
		return WYS / Block.BLOCK_SIZE;
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		for(int k = 0; k < Key.UP.length; k++)
		{
			if(e.getKeyCode() == Key.UP[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveUp(this))
				{
					worldObj.player.movePlayerUp();
					for(int i = 0; i < worldObj.currentTiles.size(); i++)
						if(worldObj.currentTiles.get(i) instanceof BlockEnemy)
							worldObj.currentTiles.get(i).moveEnemyDown();
				}
			}
		}
		for(int k = 0; k < Key.DOWN.length; k++)
		{
			if(e.getKeyCode() == Key.DOWN[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveDown(this))
				{
					worldObj.player.movePlayerDown();
					for(int i = 0; i < worldObj.currentTiles.size(); i++)
						if(worldObj.currentTiles.get(i) instanceof BlockEnemy)
							worldObj.currentTiles.get(i).moveEnemyUp();
				}
			}
		}
		for(int k = 0; k < Key.LEFT.length; k++)
		{
			if(e.getKeyCode() == Key.LEFT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveLeft(this))
				{
					worldObj.player.movePlayerLeft();
					for(int i = 0; i < worldObj.currentTiles.size(); i++)
						if(worldObj.currentTiles.get(i) instanceof BlockEnemy)
							worldObj.currentTiles.get(i).moveEnemyRight();
				}
			}
		}
		for(int k = 0; k < Key.RIGHT.length; k++)
		{
			if(e.getKeyCode() == Key.RIGHT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveRight(this))
				{
					if(!EventCheckForNextLevel.check(worldObj))
					{
						worldObj.player.movePlayerRight();
						for(int i = 0; i < worldObj.currentTiles.size(); i++)
							if(worldObj.currentTiles.get(i) instanceof BlockEnemy)
								worldObj.currentTiles.get(i).moveEnemyLeft();
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("lines".equals(e.getActionCommand()))
		{
			if(Block.isShowingLines)
				Block.isShowingLines = false;
			else
				Block.isShowingLines = true;
		}
	}
}
