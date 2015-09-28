package seia.gra.utils.matrix;

/*
 * Created by: Krzysztof D. 2015
 */
public interface IMatrix<T> 
{
	public abstract int getSizeX();
	public abstract int getSizeY();
	public abstract T[][] buildMatrix();
}
