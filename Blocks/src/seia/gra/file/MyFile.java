package seia.gra.file;

import java.io.File;

public class MyFile extends File
{
	private static final long serialVersionUID = 614181312989898386L;

	public MyFile(String pathname) 
	{
		super(pathname);
		FilesHandler.addFile(this);
	}
}
