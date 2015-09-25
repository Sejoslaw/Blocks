package seia.gra.utils;

public class MatrixHelper
{
	public abstract class Matrix<T>
	{
		public abstract int getSizeX();
		public abstract int getSizeY();
		public abstract T[][] buildMatrix();
	}
	
	public abstract class MatrixSquare<T> extends Matrix<T>
	{
		public T[][] MATRIX;
		public int SIZE;
		
		public MatrixSquare(int size)
		{
			this.SIZE = size;
		}
		
		public int getSizeX()
		{
			return SIZE;
		}
		
		public int getSizeY()
		{
			return SIZE;
		}
		
		public abstract T[][] buildMatrix();
	}
	
	public static <T> int[][] setZeroOneMatrix(T[][] matrixT)
	{
		int[][] tab = new int[matrixT.length][matrixT[0].length];
		for(int i = 0; i < tab.length; i++)
			for(int j = 0; j < tab[0].length; j++)
			{
				if(matrixT[i][j] == null)
					tab[i][j] = 0;
				else
					tab[i][j] = 1;
			}
		return tab;
	}
	
	public static <T> Object[][] toObjectArraySquareMatrix(T[][] matrixT)
	{
		int size = matrixT.length;
		Object[][] arObj = new Object[size][size];
		for(int j = 0; j < size; j++)
			for(int i = 0; i < size; i++)
				arObj[i][j] = (Object) matrixT[i][j];
		return arObj;
	}
	
	public static <T> Object[][] toObjectArray(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int j = 0; j < sizeY; j++)
			for(int i = 0; i < sizeX; i++)
				mat[i][j] = (Object) matrixT[i][j];
		return mat;
	}
	
	public static <T> T[][] reverseShapeVerticallySquareMatrix(T[][] matrixT)
	{
		T[][] matrix = matrixT.clone();
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int j = 0; j < matrixSize; j++)
			for(int i = 0; i < matrixSize; i++)
				if(i < (rowSize / 2))
					matrix[i][j] = matrix[rowSize - i][j];
		return matrix;
	}
	
	public static <T> T[][] reverseShapeHorizontallySquareMatrix(T[][] matrixT)
	{
		T[][] matrix = matrixT.clone();
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				if(j < (rowSize / 2))
					matrix[i][j] = matrix[i][rowSize - j];
		return matrix;
	}
	
	public static <T> T[][] rotateRightSquareMatrix(T[][] matrixT)
	{
		T[][] matrix = matrixT.clone();
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = matrixT[matrixSize - j - 1][i];
		return matrix;
	}
	
	public static <T> T[][] rotateLeftSquareMatrix(T[][] matrixT)
	{
		T[][] matrix = matrixT.clone();
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = matrixT[j][matrixSize - i - 1];
		return matrix;
	}
	
	public static <T> T[][] transposeSquareMatrix(T[][] matrixT)
	{
		T[][] matrix = matrixT.clone();
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = matrixT[j][i];
		return matrix;
	}
	
	public static <T> Object[][] transpose(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int j = 0; j < sizeY; j++)
			for(int i = 0; i < sizeX; i++)
				mat[i][j] = (Object) matrixT[j][i];
		return mat;
	}
	
	public static <T> boolean czyMacierzZwrotna(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			if(matrixT[i][i] == null)
				return false;
		return true;
	}
	
	public static <T> boolean czyMacierzPrzeiwzwrotna(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			if(matrixT[i][i] != null)
				return false;
		return true;
	}

	public static <T extends Comparable<T>> boolean isMatrixSymmetrical(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			for(int j = i + 1; j < matrixT.length; j++)
				if(matrixT[i][j].compareTo(matrixT[j][i]) != 0)
					return false;
		return true;
	}

	public static <T> boolean isMatrixSymmetrical2(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			for(int j = i + 1; j < matrixT.length; j++)
				if(matrixT[i][j] != matrixT[j][i])
					return false;
		return true;
	}

	public static <T> boolean isMatrixSymmetrical3(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			for(int j = i + 1; j < matrixT.length; j++)
				if(!(matrixT[i][j].equals(matrixT[j][i])))
					return false;
		return true;
	}
	
	public static <T> boolean isMatrixAntySymmetrical(T[][] matrixT)
	{
		int[][] tab = setZeroOneMatrix(matrixT);
		for(int i = 0; i < tab.length; i++)
			for(int j = 0; j < tab[0].length; j++)
				if(tab[i][j] * tab[j][i] == 1)
					return false;
		return true;
	}
	
}
