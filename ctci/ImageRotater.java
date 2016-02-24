package ctci;

public class ImageRotater	{
	public static void main(String [] args)	{
		int [][] matrix = {{1, 2, 1, 5, 1}, {2, 2, 3, 4, 6}, {4, 2, 1, 5, 3}, {6, 3, 1, 2, 3}, {1, 1, 1, 1, 2}};
		printMatrix(matrix, 5);
		System.out.println();
		printMatrix(rotateRight(matrix, 5), 5);
	}

	public static int [][] rotateRight(int [][] matrix, int N)	{
		int x = N - 1;
		int [][] rotated = new int [N][N];
		for (int i = 0; i < N; i++)	{
			for (int j = 0; j < N; j++)	{
				rotated [j][x] = matrix [i][j];
				// System.out.println(Integer.toString(rotated [i][j]));
			}

			x--;
		}

		return rotated;
	}

	public static void printMatrix(int [][] matrix, int N)	{
		for (int i = 0; i < N; i++)	{
			for (int j = 0; j < N; j++)	{
				System.out.print(Integer.toString(matrix[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
