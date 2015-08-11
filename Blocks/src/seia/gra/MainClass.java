package seia.gra;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import seia.gra.block.Block;
import seia.gra.event.EventCheckCollisionWithEnemy;
import seia.gra.event.EventCheckForNextLevel;
import seia.gra.file.FileConfig;
import seia.gra.utils.Key;
import seia.gra.world.World;
import seia.gra.world.renderer.WorldRendererHeart;

public class MainClass extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	public Timer tm = new Timer(1, null); //miliseconds
	private static int SZER, WYS;
	public World world;
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
		world = new World(szer, wys, setHeart, nick);
		
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
					world.player.moveUpPlayer(world);
					for(int i = 0; i < world.enemy.size(); i++)
						world.enemy.get(i).moveDownEnemy(world);
				}
			}
		}
		for(int k = 0; k < Key.DOWN.length; k++)
		{
			if(e.getKeyCode() == Key.DOWN[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveDown(this))
				{
					world.player.moveDownPlayer(world);
					for(int i = 0; i < world.enemy.size(); i++)
						world.enemy.get(i).moveUpEnemy(world);
				}
			}
		}
		for(int k = 0; k < Key.LEFT.length; k++)
		{
			if(e.getKeyCode() == Key.LEFT[k])
			{
				if(EventCheckCollisionWithEnemy.canPlayerMoveLeft(this))
				{
					world.player.moveLeftPlayer(world);
					for(int i = 0; i < world.enemy.size(); i++)
						world.enemy.get(i).moveRightEnemy(world);
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
						world.player.moveRightPlayer(world);
						for(int i = 0; i < world.enemy.size(); i++)
							world.enemy.get(i).moveLeftEnemy(world);
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
