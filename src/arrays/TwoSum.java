package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * Problem 1
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * @author Matt
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(nums, 9)));
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
