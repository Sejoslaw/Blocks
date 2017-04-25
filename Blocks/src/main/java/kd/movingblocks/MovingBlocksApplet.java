package main.java.kd.movingblocks;

import javax.swing.JApplet;

/**
 * Moving Blocks Java Applet.
 * Used to showing Moving Blocks in Web Browser.
 * 
 * Adding to browser:
 * <applet code=MovingBlocksApplet.class archive="MovingBlocks-XXX.jar" width=X height=X />
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MovingBlocksApplet extends JApplet
{
	private static final long serialVersionUID = 443968988927409880L;
	
	/**
	 * Method used to initialize Applet. 
	 * Invoked only once.
	 */
	public void init() // Equivalent of Constructor
	{
	}
	
	/**
	 * Invoked AFTER init() OR browser was maximized.
	 * Used to start the Applet.
	 */
	public void start()
	{
	}
	
	/**
	 * Used to stop the Applet.
	 * Invoked when Applet was stopped OR browser was minimized.
	 */
	public void stop()
	{
	}
	
	/**
	 * Used to destroy the Applet.
	 * Invoked only once.
	 */
	public void destroy()
	{
	}
}