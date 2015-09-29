package seia.gra.utils.matrix;

/*
 * Created by: Krzysztof Dobrzyński 2015
 */
public class MatrixHelper
{
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
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				arObj[i][j] = (Object) matrixT[i][j];
		return arObj;
	}
	
	public static <T> Object[][] toObjectArray(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
			for(int j = 0; j < sizeX; j++)
				mat[i][j] = (Object) matrixT[i][j];
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] reverseShapeVerticallySquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				if(i < (rowSize / 2))
					matrix[i][j] = matrix[rowSize - i][j];
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrixT[i][j] = (T) matrix[i][j];
		return matrixT;
	}
	
	public static <T> Object[][] reverseShapeVertically(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
			for(int j = 0; j < sizeX; j++)
				if(i < (sizeX / 2))
					mat[i][j] = (Object) matrixT[sizeX - i][j];
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] reverseShapeHorizontallySquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				if(j < (rowSize / 2))
					matrix[i][j] = matrix[i][rowSize - j];
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrixT[i][j] = (T) matrix[i][j];
		return matrixT;
	}
	
	public static <T> Object[][] reverseShapeHorizontally(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
			for(int j = 0; j < sizeX; j++)
				if(i < (sizeY / 2))
					mat[i][j] = (Object) matrixT[i][sizeY - j];
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rotateRightSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = matrixT[matrixSize - j - 1][i];
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrixT[i][j] = (T) matrix[i][j];
		return matrixT;
	}
	
	public static <T> Object[][] rotateRight(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] matrix = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
			for(int j = 0; j < sizeX; j++)
				matrix[i][j] = matrixT[sizeY - j - 1][i];
		return matrix;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rotateLeftSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = matrixT[j][matrixSize - i - 1];
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrixT[i][j] = (T) matrix[i][j];
		return matrixT;
	}
	
	public static <T> Object[][] rotateLeft(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] matrix = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
			for(int j = 0; j < sizeX; j++)
				matrix[i][j] = matrixT[j][sizeY - i - 1];
		return matrix;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] transposeSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrix[i][j] = (Object) matrixT[j][i];
		for(int i = 0; i < matrixSize; i++)
			for(int j = 0; j < matrixSize; j++)
				matrixT[i][j] = (T) matrix[i][j];
		return matrixT;
	}
	
	public static <T> Object[][] transpose(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++)
			for(int j = 0; j < sizeY; j++)
				mat[i][j] = (Object) matrixT[j][i];
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rebuildMatrixAfterTransposition(T[][] matrix)
	{
		Object[][] objAr = transpose(matrix);
		return (T[][]) objAr;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] toTArray(Object[][] matrixO)
	{
		return (T[][]) matrixO;
	}
	
	/**
	 * @return - isMatrixReturnable ???
	 */
	public static <T> boolean czyMacierzZwrotna(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
			if(matrixT[i][i] == null)
				return false;
		return true;
	}
	
	public static <T> boolean czyMacierzPrzeciwzwrotna(T[][] matrixT)
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
	
	public static <T extends Comparable<T>> T getMaxFromMatrix(T[][] matrixT)
	{
		T max = matrixT[0][0];
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		for(int i = 0; i < sizeX; i++)
			for(int j = 0; j < sizeY; j++)
				if(max.compareTo(matrixT[i][j]) <= 0)
					max = matrixT[i][j];
		return max;
	}
	
	public static <T extends Comparable<T>> T getMinFromMatrix(T[][] matrixT)
	{
		T min = matrixT[0][0];
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		for(int i = 0; i < sizeX; i++)
			for(int j = 0; j < sizeY; j++)
				if(min.compareTo(matrixT[i][j]) > 0)
					min = matrixT[i][j];
		return min;
	}
	
}
