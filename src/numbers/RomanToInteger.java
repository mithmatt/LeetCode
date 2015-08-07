package numbers;

/**
 * 
 * Problem 13
 * 
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author Matt
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("LMIX"));
	}

	private static int romanToInt(String s) {

		int curr = 0, prev = 0, result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			curr = getInt(s.charAt(i));

			if (curr >= prev)
				result += curr;
			else
				result -= curr;

			prev = curr;
		}

		return result;
	}

	private static int getInt(char roman) {

		switch (roman) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
