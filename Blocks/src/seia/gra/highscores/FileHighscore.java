package seia.gra.highscores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import seia.gra.MainClass;
import seia.gra.file.FilesHandler;
import seia.gra.file.MyFile;
import seia.gra.utils.SortingHelper;

public class FileHighscore extends MyFile
{
	private static final long serialVersionUID = 3571658019737408039L;
	private ArrayList<ObjectHighscoreLine> highscoreLines = new ArrayList<ObjectHighscoreLine>();
	/**
	 * Zawsze bedzie ostatnia pozycja nazwy gracza
	 */
	private final int nickPosition = 3;
	private final int arguments = 3;

	public FileHighscore(String pathname) 
	{
		super(pathname);
	}

	public void reloadHighscore(MainClass mc) //TODO
	{
		try
		{
			readHighscore();
			addToHighscore(mc);
			FilesHandler.HIGHSCORE.delete();
			FilesHandler.HIGHSCORE.createNewFile();
			reload();
			save();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Zapis listy wynikow do pliku
	 */
	public void save() //TODO
	{
		try 
		{
			PrintWriter pw = new PrintWriter(FilesHandler.HIGHSCORE);
			for(ObjectHighscoreLine ohl : highscoreLines)
			{
				StringBuilder sb = new StringBuilder()
						.append(ohl.positionOnList)
						.append(" ")
						.append(ohl.level)
						.append(" ")
						.append(ohl.nick);
				String s = sb.toString();
				pw.println(s);
			}
			pw.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Przeladowanie listy wynikow
	 */
	public void reload() //TODO
	{
		int size = highscoreLines.size();
		ObjectHighscoreLine[] cpy = new ObjectHighscoreLine[size];
		for(int i = 0; i < highscoreLines.size(); i++)
			cpy[i] = highscoreLines.get(i);
		cpy = SortingHelper.insertSort(cpy); //TODO
		for(int i = 1; i < highscoreLines.size() + 1; i++)
			highscoreLines.get(i - 1).positionOnList = i;
	}
	
	/**
	 * Dodanie do listy wynikow
	 */
	public void addToHighscore(MainClass mc)
	{
		ObjectHighscoreLine newLine = new ObjectHighscoreLine(-1, mc.world.getCurrentLevelValue(), mc.nick);
		highscoreLines.add(newLine);
	}
	/**
	 * Napelnienie listy wynikow
	 */
	public void readHighscore() //TODO
	{
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FilesHandler.HIGHSCORE));
			String line = br.readLine();
			lines.add(line);
			while(line != null)
			{
				line = br.readLine();
				lines.add(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < lines.size(); i++)
		{
			try
			{
				char[] achar = lines.get(i).toCharArray();
				String[] stab = new String[3];
				int newStart = 0;
				int newEnd = 0;
				for(int n = 0; n < arguments; n++)
				{
					if(n == nickPosition - 1)
					{
						String s = lines.get(i).substring(newStart, achar.length);
						stab[n] = s;
					}
					else
					{
						for(int j = newStart; j < achar.length; j++)
						{
							if(achar[j] == ' ')
							{
								newEnd = j;
								break;
							}
						}
						String s = lines.get(i).substring(newStart, newEnd);
						newStart = newEnd + 1;
						newEnd = newStart;
						stab[n] = s;
					}
				}
				int position = Integer.parseInt(stab[0]);
				int level = Integer.parseInt(stab[1]);
				highscoreLines.add(new ObjectHighscoreLine(position, level, stab[2]));
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		}
	}
}
