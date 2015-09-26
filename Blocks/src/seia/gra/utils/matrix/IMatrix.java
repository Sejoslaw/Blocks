package seia.gra.utils.matrix;

public interface IMatrix<T> 
{
	public abstract int getSizeX();
	public abstract int getSizeY();
	public abstract T[][] buildMatrix();
}
