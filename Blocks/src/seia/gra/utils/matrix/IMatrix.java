package seia.gra.utils.matrix;

/*
 * Created by: Krzysztof Dobrzynski 2015
 */
public interface IMatrix<T> 
{
	public int getSizeX();
	public int getSizeY();
	public T[][] buildMatrix();
	public void print();
}
