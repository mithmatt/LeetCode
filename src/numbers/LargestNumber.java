package numbers;
import java.util.*;

/**
 * 
 * Problem 179
 * 
 * https://leetcode.com/problems/largest-number/
 * 
 * @author Matt
 *
 */
public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = { 999999998, 999999997, 999999999 };

		System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		StringNum[] numbers = new StringNum[nums.length];

		for (int i = 0; i < nums.length; i++)
			numbers[i] = new StringNum(nums[i]);

		Arrays.sort(numbers, new NumberComparator());

		StringBuilder result = new StringBuilder();

		boolean start = true;

		for (StringNum each : numbers) {
			if (!(start && each.num == 0)) {
				result.append(each.val);
				start = false;
			}
		}

		String res = result.toString();

		return (res.length() == 0) ? "" + 0 : res;
	}

	public static class StringNum {
		int num;
		String val;

		public StringNum(int x) {
			val = "" + x;
			num = x;
		}
	}

	public static class NumberComparator implements Comparator<StringNum> {

		@Override
		public int compare(StringNum a, StringNum b) {
			return compareDigit(a.val, b.val, a.val.length(), b.val.length());
		}

		private int compareDigit(String a, String b, int m, int n) {

			for (int i = 0; i < m * n; i++) {
				if (a.charAt(i % m) < b.charAt(i % n))
					return 1;
				if (a.charAt(i % m) > b.charAt(i % n))
					return -1;
			}
			return 0;
		}
	}

}
