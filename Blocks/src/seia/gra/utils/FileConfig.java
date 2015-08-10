package seia.gra.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import seia.gra.block.Block;

public class FileConfig 
{
	public static final File CONFIG = new File("Blocks_Config.bl");
	public static List<String> configLines = new ArrayList<String>();

	public static void checkConfig() 
	{
		if(CONFIG.exists())
		{
			Block.isShowingLines = getShowLines();
		}
		else
		{
			try 
			{
				CONFIG.createNewFile();
				PrintWriter writer = new PrintWriter(CONFIG);
				addToList();
				for(int i = 0; i < configLines.size(); i++)
				{
					writer.println(configLines.get(i));
				}
				writer.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			checkConfig();
		}
	}
	
	private static void addToList() 
	{
		configLines.add("showlines=false");
	}

	public static String[] readConfig()
	{
		List<String> list = new ArrayList<String>();
		String[] tab = null;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(CONFIG));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			list.add(line);
			while(line != null)
			{
				line = br.readLine();
				list.add(line);
			}
			tab = new String[list.size()];
			for(int i = 0; i < tab.length; i++)
			{
				tab[i] = list.get(i);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tab;
	}
	
	public static boolean getShowLines()
	{
		String[] tab = readConfig();
		return Boolean.parseBoolean(tab[0].substring(10, tab[0].length()));
	}
}
