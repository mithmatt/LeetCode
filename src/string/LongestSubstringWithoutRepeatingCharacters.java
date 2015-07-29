package string;

import java.util.HashMap;

/**
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author Matt
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	private static int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();

		int i = 0, longest = 0, start = 0;

		for (i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (myMap.containsKey(ch) && myMap.get(ch) >= start) {
				longest = Math.max(longest, i - start);
				start = myMap.get(ch) + 1;
			}

			myMap.put(ch, i);
		}

		longest = Math.max(longest, i - start);

		return longest;
	}
}
