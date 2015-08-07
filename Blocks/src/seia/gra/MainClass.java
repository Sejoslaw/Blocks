package seia.gra;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import seia.gra.block.Block;
import seia.gra.block.BlockEnemy;
import seia.gra.block.BlockPlayer;
import seia.gra.utils.Key;
import seia.gra.world.World;

public class MainClass extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	public Timer tm = new Timer(5, null);
	private static int SZER, WYS;
	public int enemyNumber;
	public int rX, rY;
	public World world;
	public BlockPlayer player;
	public List<BlockEnemy> enemy = new ArrayList<BlockEnemy>();

	public MainClass(int szer, int wys)
	{
		tm.start();
		SZER = szer;
		WYS = wys;
		player = new BlockPlayer(1, 1);
		world = new World(szer, wys);
		enemyNumber = new Random().nextInt(10);
		for(int i = 0; i < enemyNumber; i++)
		{
			addEnemy();
		}
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	private boolean addEnemy() 
	{
		rX = new Random().nextInt(SZER / Block.BLOCK_SIZE);
		rY = new Random().nextInt(WYS / Block.BLOCK_SIZE);
		if((rX != 1) && (rY != 1))
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

	public void paintComponent(Graphics g)
	{
		world.paintComponent(g);
		for(int i = 0; i < enemyNumber; i++)
		{
			if((player.X == enemy.get(i).X) && (player.Y == enemy.get(i).Y))
			{
				JOptionPane.showMessageDialog(this, "Game Over :(");
				System.exit(0);
			}
		}
		for(int  i = 0; i < enemyNumber; i++)
		{
			enemy.get(i).paintComponent(g);
		}
		player.paintComponent(g);
		repaint();
	}
	
	public static int getWidthInBlocks()
	{
		return SZER / Block.BLOCK_SIZE;
	}
	
	public static int getHeightInBlocks()
	{
		return WYS / Block.BLOCK_SIZE;
	}
	
	public static void main(String[] args) 
	{
		int szer = 1000;
		int wys = 600;
		
		String s1 = JOptionPane.showInputDialog("Czy pokazac linie ? (true / false)");
		boolean line = Boolean.parseBoolean(s1.toLowerCase());
		Block.isShowingLines = line;
		
		MainClass mc = new MainClass(szer, wys);
		JFrame f = new JFrame("Blocks");
		f.setSize(szer, wys);
		f.setVisible(true);
		f.add(mc);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JOptionPane.showMessageDialog(mc, "Nie dotykaj czerwonych !!!");
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		for(int k = 0; k < Key.UP.length; k++)
		{
			if(e.getKeyCode() == Key.UP[k])
			{
				player.moveUpPlayer(player, world);
				for(int i = 0; i < enemy.size(); i++)
					enemy.get(i).moveDownEnemy(enemy.get(i), world);
			}
		}
		for(int k = 0; k < Key.DOWN.length; k++)
		{
			if(e.getKeyCode() == Key.DOWN[k])
			{
				player.moveDownPlayer(player, world);
				for(int i = 0; i < enemy.size(); i++)
					enemy.get(i).moveUpEnemy(enemy.get(i), world);
			}
		}
		for(int k = 0; k < Key.LEFT.length; k++)
		{
			if(e.getKeyCode() == Key.LEFT[k])
			{
				player.moveLeftPlayer(player, world);
				for(int i = 0; i < enemy.size(); i++)
					enemy.get(i).moveRightEnemy(enemy.get(i), world);
			}
		}
		for(int k = 0; k < Key.RIGHT.length; k++)
		{
			if(e.getKeyCode() == Key.RIGHT[k])
			{
				player.moveRightPlayer(player, world);
				for(int i = 0; i < enemy.size(); i++)
					enemy.get(i).moveLeftEnemy(enemy.get(i), world);
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
	}
}
