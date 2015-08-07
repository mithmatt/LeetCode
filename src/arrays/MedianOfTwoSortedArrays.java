package arrays;

/**
 * 
 * Problem 4
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author Matt
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 7, 9 };
		int[] nums2 = { 2, 4, 6, 8, 10 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] result = new int[m + n];

		if (result.length == 0)
			return -1;

		int i = 0, j = 0, k = 0;
		int mid = result.length / 2;

		boolean even = false;

		if (result.length % 2 == 0)
			even = true;

		while (i < m && j < n) {
			if (nums1[i] < nums2[j])
				result[k++] = nums1[i++];
			else
				result[k++] = nums2[j++];

			if (even && k == mid + 1)
				return ((double) (result[k - 1] + result[k - 2]) / 2);
			else if (!even && k == mid + 1)
				return result[k - 1];
		}

		while (i < m) {
			result[k++] = nums1[i++];

			if (even && k == mid + 1)
				return ((double) (result[k - 1] + result[k - 2]) / 2);
			else if (!even && k == mid + 1)
				return result[k - 1];
		}

		while (j < n) {
			result[k++] = nums2[j++];

			if (even && k == mid + 1)
				return ((double) (result[k - 1] + result[k - 2]) / 2);
			else if (!even && k == mid + 1)
				return result[k - 1];
		}

		return -1;
	}
}
