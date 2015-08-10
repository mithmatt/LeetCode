package arrays;

/**
 * 
 * Problem 26
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author Matt
 *
 */
public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] A = { 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 7, 7 };

		int k = removeDuplicates(A);

		for (int i = 0; i < k; i++)
			System.out.print(A[i] + " ");
	}

	private static int removeDuplicates(int[] A) {
		if (A.length <= 1)
			return A.length;

		int p1 = 0, p2 = 1, count = 1;

		while (p2 < A.length) {
			if (A[p1] == A[p2])
				p2++;

			else {
				A[p1 + 1] = A[p2];
				p2++;
				p1++;
			}

		}
		return p1 + 1;
	}

}
