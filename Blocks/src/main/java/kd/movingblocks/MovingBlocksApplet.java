package main.java.kd.movingblocks;

import javax.swing.JApplet;

/**
 * Moving Blocks Java Applet.
 * Used to showing Moving Blocks in Web Browser.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocksApplet extends JApplet
{
	private static final long serialVersionUID = 443968988927409880L;
	
	/**
	 * Main Frame
	 */
	private MovingBlocksCanvas _canvas;
	
	/**
	 * Method used to initialize Applet. 
	 * Invoked only once.
	 */
	public void init() // Equivalent of Constructor
	{
		this._canvas = new MovingBlocksCanvas();
		
		this.add(this._canvas, "Center");
		this.validate();
		
		this._canvas.start();
	}
}