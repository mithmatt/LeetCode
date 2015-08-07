package string;

/**
 * 
 * Problem 14
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * @author Matt
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "abcd", "absdkfhkds", "ab", "ab", "abkdhsfkj" };
		System.out.println(longestCommonPrefix(strs));
	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		boolean br = false;
		int i = 0;

		for (i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++)
				if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
					br = true;
					break;
				}

			if (br)
				break;
		}

		return strs[0].substring(0, i);
	}

}
