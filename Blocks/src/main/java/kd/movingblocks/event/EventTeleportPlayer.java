package main.java.kd.movingblocks.event;

import main.java.kd.movingblocks.MovingBlocks;
import main.java.kd.movingblocks.camera.Camera;
import main.java.kd.movingblocks.util.BlockPos;

/**
 * This Event occures when Player moves to next level.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class EventTeleportPlayer extends Event 
{
	public void doAction() 
	{
		// Reset Enemies (Clear + load new Enemies)
		int enemiesCount = MovingBlocks.INSTANCE.getWorld().getEnemies().size(); // store value
		MovingBlocks.INSTANCE.getWorld().getEnemies().clear(); // Clear Enemies
		for (int i = 0; i < enemiesCount + 1; ++i) // Reload new Enemies
			MovingBlocks.INSTANCE.getWorld().addNewEnemy();
		
		// Reset Teleporter position
		MovingBlocks.INSTANCE.getWorld().getTeleport().reloadPosition();
		
		// Set Player's new position
		MovingBlocks.INSTANCE.getPlayer().setPosition(1, BlockPos.getRandomCoord());
		
		// Increase Level value
		Camera.INSTANCE.goToNextLevel();
		
		// Add Player a additional hit for completing a level
		MovingBlocks.INSTANCE.getPlayer().addHits(1);
	}
}