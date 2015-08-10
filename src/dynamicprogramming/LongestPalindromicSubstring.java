package dynamicprogramming;

/**
 * 
 * Problem 5
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author Matt
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("cdfdabbadcd"));
	}

	private static String longestPalindrome(String s) {

		if (s == null)
			return null;

		String longest = "" + s.charAt(0);

		int len = s.length();
		boolean[][] t = new boolean[len][len];
		int m, n;

		for (int i = 0; i < len; i++)
			t[i][i] = true;

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				t[i][i + 1] = true;

				if (longest.length() < 2)
					longest = s.substring(i, i + 2);
			}
		}

		for (int i = 3; i <= len; i++) {
			for (int j = 0; i + j <= len; j++) {
				m = j;
				n = i + j - 1;

				if (s.charAt(m) == s.charAt(n) && t[m + 1][n - 1]) {
					t[m][n] = true;

					if (longest.length() < n - m + 1)
						longest = s.substring(m, n + 1);
				}
			}
		}

		return longest;
	}

}
