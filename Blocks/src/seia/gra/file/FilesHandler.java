package seia.gra.file;

import java.io.File;
import java.util.ArrayList;

public class FilesHandler
{
	private static ArrayList<File> FILES = new ArrayList<File>();
	public static final FileConfig CONFIG = new FileConfig("Blocks.CONFIG");

	public static void addFile(File file)
	{
		if(FILES == null)
			FILES = new ArrayList<File>();
		FILES.add(file);
	}
	
	public static ArrayList<File> getFilesList()
	{
		return FILES;
	}
}