package arrays;

/**
 * 
 * Problem 240
 * 
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * @author Matt
 *
 */
public class Searcha2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };

		System.out.println(searchMatrix(matrix, 5));
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int r = 0, c = n - 1;

		while (r <= m - 1 && c >= 0) {
			if (matrix[r][c] > target)
				c--;
			else if (matrix[r][c] < target)
				r++;
			else
				return true;
		}

		return false;
	}

}
