package seia.gra.api.block;

public interface IBlockMovable extends IBlock
{
	public boolean movePlayerUp();
	public boolean moveEnemyUp();
	public boolean movePlayerDown();
	public boolean moveEnemyDown();
	public boolean movePlayerLeft();
	public boolean moveEnemyLeft();
	public boolean movePlayerRight();
	public boolean moveEnemyRight();
}
