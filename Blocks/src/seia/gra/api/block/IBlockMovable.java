package seia.gra.api.block;

public abstract interface IBlockMovable extends IBlock
{
	public abstract boolean movePlayerUp();
	public abstract boolean moveEnemyUp();
	public abstract boolean movePlayerDown();
	public abstract boolean moveEnemyDown();
	public abstract boolean movePlayerLeft();
	public abstract boolean moveEnemyLeft();
	public abstract boolean movePlayerRight();
	public abstract boolean moveEnemyRight();
}
