package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/two-sum/
 * 
 * @author Matt
 *
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 0, 1, -4, 3, 7, -5, 0 };
		System.out.println(Arrays.toString(twoSum(nums, 2)));

	}

	private static int[] twoSum(int[] numbers, int target) {

		if (numbers.length >= 2) {
			HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
			for (int i = 0; i < numbers.length; i++) {
				if (!h.isEmpty() && h.containsKey(target - numbers[i])) {
					int[] k = { h.get(target - numbers[i]) + 1, i + 1 };
					return k;
				}
				h.put(numbers[i], i);
			}
		}

		int[] k = { -1, -1 };
		return k;
	}

}
