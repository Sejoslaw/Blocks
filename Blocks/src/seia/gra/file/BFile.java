package seia.gra.file;

import java.io.File;

public class BFile extends File
{
	private static final long serialVersionUID = 614181312989898386L;

	public BFile(String pathname) 
	{
		super(pathname);
		FilesHandler.addFile(this);
	}
}