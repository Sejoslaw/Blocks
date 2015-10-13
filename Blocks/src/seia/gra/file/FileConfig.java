package seia.gra.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import seia.gra.MainClass;
import seia.gra.api.block.Block;

public class FileConfig extends MyFile
{
	public List<String> configLines = new ArrayList<String>();
	public int avaiableHits = 10;
	
	private static final long serialVersionUID = 6317863730564877917L;

	public FileConfig(String pathname) 
	{
		super(pathname);
	}

	/**
	 * Dodawanie linijek do Blocks.Config
	 * Wraz z domyslna wartoscia
	 */
	private void addToList()
	{
		configLines.add("show_lines=" + Block.isShowingLines);
		configLines.add("basic_available_hits=" + avaiableHits);
	}
	
	public void checkConfig(MainClass mc)
	{
		if(FilesHandler.CONFIG.exists())
		{
			Block.isShowingLines = getShowLines(mc);
			avaiableHits = getBasicAvailableHits(mc);
		}
		else
		{
			try 
			{
				FilesHandler.CONFIG.createNewFile();
				PrintWriter writer = new PrintWriter(FilesHandler.CONFIG);
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
				Block.isShowingLines = true;
				avaiableHits = 10;
			}
		}
	}

	public String[] readConfig(MainClass mc)
	{
		List<String> list = new ArrayList<String>();
		String[] tab = null;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FilesHandler.CONFIG));
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
	
	public boolean getShowLines(MainClass mc)
	{
		String[] tab = readConfig(mc);
		boolean showLines = Block.isShowingLines;
		try
		{
			showLines = Boolean.parseBoolean(tab[0].substring(11, tab[0].length()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return showLines;
	}
	
	public int getBasicAvailableHits(MainClass mc)
	{
		String[] tab = readConfig(mc);
		int hits = avaiableHits;
		try
		{
			hits = Integer.parseInt(tab[1].substring(21, tab[1].length()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hits;
	}
}
