package seia.gra;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import seia.gra.block.Block;
import seia.gra.block.movable.BlockEnemy;
import seia.gra.block.movable.BlockPlayer;
import seia.gra.block.nonmovable.BlockNextLevel;
import seia.gra.event.EventCheckCollisionWithEnemy;
import seia.gra.event.EventCheckForNextLevel;
import seia.gra.file.FileConfig;
import seia.gra.utils.Key;
import seia.gra.world.World;
import seia.gra.world.renderer.WorldRendererHeart;
import seia.gra.world.worldelement.WorldElementAvailableHits;
import seia.gra.world.worldelement.WorldElementLevelValue;
import seia.gra.world.worldelement.WorldElementNick;

public class MainClass extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	public Timer tm = new Timer(1, null); //miliseconds
	private static int SZER, WYS;
	public World world;
	public BlockPlayer player;
	private static List<BlockEnemy> enemy = new ArrayList<BlockEnemy>();
	public BlockNextLevel nextLevel;
	private boolean setHeart;
	public JFrame frame;
	public JButton buttonShowLines;

	public MainClass(int szer, int wys, boolean setHeart, String nick)
	{
		tm.start();
		SZER = szer;
		WYS = wys;
		this.setHeart = setHeart;
		FileConfig.checkConfig(this);
		player = new BlockPlayer(1, 1);
		world = new World(szer, wys, setHeart);
		nextLevel = new BlockNextLevel(BlockNextLevel.getWidth(), BlockNextLevel.getRandHeight());
		setNick(nick);
		setAvailableHits();
		if(setHeart)
		{
			losEnemy(0);
		}
		else
		{
			losEnemy(90);//new Random().nextInt(95);
		}
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		frame = new JFrame("Blocks");
		frame.setSize(szer, wys);
		addItemsToFrame(); //frame.add(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void addItemsToFrame()
	{
		frame.add(this);
		//addAdditionalItems();
	}
	
	public void addAdditionalItems()
	{
		buttonShowLines = new JButton("Lines");
		buttonShowLines.setVerticalTextPosition(AbstractButton.CENTER);
		buttonShowLines.setBounds(100, 100, 50, 50);
		buttonShowLines.setVisible(true);
		buttonShowLines.addActionListener(this);
		buttonShowLines.setLayout(new FlowLayout());
		buttonShowLines.setActionCommand("lines");
		buttonShowLines.setEnabled(true);
		frame.add(buttonShowLines);
	}
	
	public void newGame()
	{
		JOptionPane.showMessageDialog(this, "Game Over :(");
		FileConfig.checkConfig(this);
		reloadPanel();
		updateLevelValue(1);
		setAvailableHits();
	}
	
	public void reloadPanel() 
	{
		world.setCurrentRendererRandom();
		player.X = 1;
		player.Y = new Random().nextInt(getHeightInBlocks() - 2) + 1;
		nextLevel.X = BlockNextLevel.getWidth();
		nextLevel.Y = BlockNextLevel.getRandHeight();
		enemy.clear();
		losEnemy(90); //new Random().nextInt(95);
	}
	
	public static List<BlockEnemy> getEnemyList()
	{
		return enemy;
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
		for(int i = 0; i < world.worldElement.size(); i++)
		{
			if(world.worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)world.worldElement.get(i)).availableHits--;
				return;
			}
		}
	}
	
	public void setAvailableHits()
	{
		for(int i = 0; i < world.worldElement.size(); i++)
		{
			if(world.worldElement.get(i).getClass().getName().equals(WorldElementAvailableHits.class.getName()))
			{
				((WorldElementAvailableHits)world.worldElement.get(i)).availableHits = FileConfig.getBasicAvailableHits();
				return;
			}
		}
	}
	
	public void setNick(String nick)
	{
		for(int i = 0; i < world.worldElement.size(); i++)
		{
			if(world.worldElement.get(i).getClass().getName().equals(WorldElementNick.class.getName()))
			{
				((WorldElementNick)world.worldElement.get(i)).nick = nick;
				return;
			}
		}
	}
	
	public void updateLevelValue() 
	{
		for(int i = 0; i < world.worldElement.size(); i++)
		{
			if(world.worldElement.get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)world.worldElement.get(i)).level++;
				return;
			}
		}
	}
	
	public void updateLevelValue(int level) 
	{
		for(int i = 0; i < world.worldElement.size(); i++)
		{
			if(world.worldElement.get(i).getClass().getName().equals(WorldElementLevelValue.class.getName()))
			{
				((WorldElementLevelValue)world.worldElement.get(i)).level = level;
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
	
	public static boolean addEnemy() 
	{
		int rX = new Random().nextInt(SZER / Block.BLOCK_SIZE);
		int rY = new Random().nextInt(WYS / Block.BLOCK_SIZE);
		if((rX != 1) && (rY != 1) && (rX != 0) && (rY != 0) && (rX != getWidthInBlocks() - 1) && (rY != getHeightInBlocks() - 1))
		{
			enemy.add(new BlockEnemy(rX, rY));
			return true;
		}
		else
		{
			addEnemy();
		}
		return false;
	}
	
	public boolean getSetHeart()
	{
		return setHeart;
	}

	public void paintComponent(Graphics g)
	{
		world.paintComponent(g);
		for(int  i = 0; i < enemy.size(); i++)
		{
			enemy.get(i).paintComponent(g);
		}
		nextLevel.paintComponent(g);
		player.paintComponent(g);
		repaint();
	}
	
	public void gameOver()
	{
		JOptionPane.showMessageDialog(this, "Game Over :(");
		System.exit(0);
	}
	
	public static int getWidthInBlocks()
	{
		return SZER / Block.BLOCK_SIZE;
	}
	
	public static int getHeightInBlocks()
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
					player.moveUpPlayer(world);
					for(int i = 0; i < enemy.size(); i++)
						enemy.get(i).moveDownEnemy(world);
				}
			}
		}
		for(int k = 0; k < Key.DOWN.length; k++)
		{
			if(e.getKeyCode() == Key.DOWN[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveDown(this))
				{
					player.moveDownPlayer(world);
					for(int i = 0; i < enemy.size(); i++)
						enemy.get(i).moveUpEnemy(world);
				}
			}
		}
		for(int k = 0; k < Key.LEFT.length; k++)
		{
			if(e.getKeyCode() == Key.LEFT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveLeft(this))
				{
					player.moveLeftPlayer(world);
					for(int i = 0; i < enemy.size(); i++)
						enemy.get(i).moveRightEnemy(world);
				}
			}
		}
		for(int k = 0; k < Key.RIGHT.length; k++)
		{
			if(e.getKeyCode() == Key.RIGHT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveRight(this))
				{
					if(!EventCheckForNextLevel.check(this))
					{
						player.moveRightPlayer(world);
						for(int i = 0; i < enemy.size(); i++)
							enemy.get(i).moveLeftEnemy(world);
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
		
		String s1 = JOptionPane.showInputDialog("Podaj nick:");
		if(s1.toLowerCase().equals(WorldRendererHeart.input.toLowerCase()))
		{
			b1 = true;
		}
		MainClass mc = new MainClass(szer, wys, b1, s1);
		JOptionPane.showMessageDialog(mc, "Nie dotykaj czerwonych !!! Zolty -> Next Level.");
	}
}
