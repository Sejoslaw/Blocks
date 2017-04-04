package seia.gra.utils.matrix;

/*
 * Created by: Krzysztof Dobrzynski 2015
 */
public abstract class Matrix<T> implements IMatrix<T>
{
	public T[][] MATRIX;
	
	public Matrix()
	{
		MATRIX = buildMatrix();
	}
	
	public int getSizeX()
	{
		return MATRIX[0].length;
	}
	
	public int getSizeY()
	{
		return MATRIX.length;
	}
	
	public abstract T[][] buildMatrix();
	
	public abstract void print();
	/**
	 * @param matrix
	 * @return this, should be fine.
	 */
	public abstract Matrix<T> create(T[][] matrix);
	
	public void printMatrix()
	{
		int sizeY = MATRIX.length;
		int sizeX = MATRIX[0].length;
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
				System.out.print(MATRIX[i][j] + " ");
			System.out.println();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T[][] transposeMatrix()
	{
		Object[][] objAr = MatrixHelper.transpose(MATRIX);
		return (T[][]) objAr;
	}
	
	@SuppressWarnings("unchecked")
	public void printMatrixAfterTransposition()
	{
		Object[][] objAr = MatrixHelper.transpose(MATRIX);
		
		int sizeY = objAr.length;
		int sizeX = objAr[0].length;
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
				System.out.print((T) objAr[i][j] + " ");
			System.out.println();
		}
		
		MATRIX = transposeMatrix();
	}
}