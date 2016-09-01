package seia.gra.highscores;

public class ObjectHighscoreLine implements Comparable<ObjectHighscoreLine>
{
	public int positionOnList;
	public int level;
	public String nick;
	
	public ObjectHighscoreLine(int posiotionOnList, int level, String nick)
	{
		this.positionOnList = posiotionOnList;
		this.level = level;
		this.nick = nick;
	}

	@Override
	public int compareTo(ObjectHighscoreLine o) 
	{
		if(level < o.level)
		{
			return -1;
		}
		else if(level > o.level)
		{
			return 1;
		}
		else
		{
			return nick.compareTo(o.nick);
		}
	}
}