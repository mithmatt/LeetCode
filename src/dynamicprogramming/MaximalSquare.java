package dynamicprogramming;

/**
 * 
 * Problem 221
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 * @author Matt
 *
 */
public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		if (r == 0)
			return 0;
		int c = matrix[0].length;
		if (c == 0)
			return 0;

		int res = 0;
		int[][] t = new int[r][c];

		for (int i = 0; i < r; i++)
			t[i][0] = Character.getNumericValue(matrix[i][0]);

		for (int i = 1; i < c; i++)
			t[0][i] = Character.getNumericValue(matrix[0][i]);

		for (int i = 1; i < r; i++)
			for (int j = 1; j < c; j++)
				if (matrix[i][j] == '1')
					t[i][j] = Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]) + 1;

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				res = Math.max(res, t[i][j]);

		return res * res;
	}

}
