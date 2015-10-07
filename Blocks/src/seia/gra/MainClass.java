package seia.gra;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import seia.gra.block.Block;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.event.EventCheckCollisionWithEnemy;
import seia.gra.event.EventCheckForNextLevel;
import seia.gra.file.FilesHandler;
import seia.gra.utils.Key;
import seia.gra.world.World;
import seia.gra.world.renderer.WorldRendererHeart;

public class MainClass extends JPanel implements ActionListener, KeyListener
{
	/**
	 * Jest -> Oba maja przejsc na nastepny poziom (najpierw jeden potem drugi).
	 * Jest -> Kiedy przejda oba to a nastepny poziom.
	 * Jest -> Sterowanie Clona po przejsciu gracza jest jak gracza przedtem.
	 * Jest -> usunac obiekt CLona i podpiac go pod gracza.
	 */
	private static final long serialVersionUID = 1L;
	
	public final String VERSION = "v0.0.7";
	
	public Timer tm = new Timer(5, null); //miliseconds
	public int SZER, WYS;
	public World world;
	public boolean setHeart;
	public JFrame frame;
	public String nick;

	public MainClass(int szer, int wys, boolean setHeart, String nick)
	{
		tm.start();
		SZER = szer;
		WYS = wys;
		this.setHeart = setHeart;
		this.nick = nick;
		FilesHandler.CONFIG.checkConfig(this); //FileConfig.checkConfig(this);
		world = new World(this);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		frame = new JFrame("Blocks " + VERSION);
		frame.setSize(szer, wys);
		addItemsToFrame(); //frame.add(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void addItemsToFrame()
	{
		frame.add(this);
	}
	
	public void newGame()
	{
		JOptionPane.showMessageDialog(this, "Game Over :(");
		//FilesHandler.HIGHSCORE.reloadHighscore(this); //TODO
		FilesHandler.CONFIG.checkConfig(this); //FileConfig.checkConfig(this);
		world.reloadPanel();
		world.updateLevelValue(1);
		world.setAvailableHits();
	}
	
	public boolean getSetHeart()
	{
		return setHeart;
	}

	public void paintComponent(Graphics g)
	{
		world.paintComponent(g);
		g.dispose();
		repaint();
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
					world.player.movePlayerUp();
					for(int i = 0; i < world.currentTiles.size(); i++)
						if(world.currentTiles.get(i) instanceof BlockEnemy)
							world.currentTiles.get(i).moveEnemyDown();
				}
			}
		}
		for(int k = 0; k < Key.DOWN.length; k++)
		{
			if(e.getKeyCode() == Key.DOWN[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveDown(this))
				{
					world.player.movePlayerDown();
					for(int i = 0; i < world.currentTiles.size(); i++)
						if(world.currentTiles.get(i) instanceof BlockEnemy)
							world.currentTiles.get(i).moveEnemyUp();
				}
			}
		}
		for(int k = 0; k < Key.LEFT.length; k++)
		{
			if(e.getKeyCode() == Key.LEFT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveLeft(this))
				{
					world.player.movePlayerLeft();
					for(int i = 0; i < world.currentTiles.size(); i++)
						if(world.currentTiles.get(i) instanceof BlockEnemy)
							world.currentTiles.get(i).moveEnemyRight();
				}
			}
		}
		for(int k = 0; k < Key.RIGHT.length; k++)
		{
			if(e.getKeyCode() == Key.RIGHT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveRight(this))
				{
					if(!EventCheckForNextLevel.check(world))
					{
						world.player.movePlayerRight();
						for(int i = 0; i < world.currentTiles.size(); i++)
							if(world.currentTiles.get(i) instanceof BlockEnemy)
								world.currentTiles.get(i).moveEnemyLeft();
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
	
	public static void main(String[] args) 
	{
		int szer = 1000;
		int wys = 600;
		boolean b1 = false;
		
		String s1;
		try
		{
			s1 = JOptionPane.showInputDialog("Podaj nick:");
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
		MainClass mc = new MainClass(szer, wys, b1, s1);
		JOptionPane.showMessageDialog(mc, "Nie dotykaj czerwonych !!! Zolty -> Next Level.");
	}
}
