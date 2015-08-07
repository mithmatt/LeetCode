package numbers;

/**
 * 
 * Problem 7
 * 
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author Matt
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-217386127));
	}

	private static int reverse(int x) {
		int rev = 0;

		while (x != 0) {
			if (Math.abs(rev) > 214748364)
				return 0;

			rev = rev * 10 + x % 10;
			x /= 10;
		}

		return rev;
	}
}
