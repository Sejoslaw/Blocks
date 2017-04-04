package test;

public class Test 
{
	public static void main(String[] args) 
	{
		int[][] matrix = new int[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrix[i][j] = i + j;
		printMatrix(matrix);
		//matrix = MatrixHelper.rotateRightSquareMatrix(matrix);
		//printMatrix(matrix);
		//matrix = MatrixHelper.setZeroOneMatrixInt(matrix);
		//matrix = MatrixHelper.reverseShapeVerticallyInt(matrix);
		//matrix = MatrixHelper.reverseShapeHorizontally(matrix);
		//matrix = MatrixHelper.rotateLeftSquareMatrix(matrix);
		//matrix = MatrixHelper.transposeSquareMatrix(matrix);
		//matrix = MatrixHelper.multiply(matrix, matrix);
		//matrix = MatrixHelper.toThePowerOf(matrix, 2);
		printMatrix(matrix);
	}
	
	public static void printMatrix(int[][] matrix)
	{
		System.out.println();
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
