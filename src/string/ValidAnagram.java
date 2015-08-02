package string;

import java.util.HashMap;

/**
 * 
 * https://leetcode.com/problems/valid-anagram/
 * 
 * @author Matt
 *
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagarma"));
	}

	private static boolean isAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> sh = new HashMap<Character, Integer>();

		char ch = 'a';
		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			num = 0;

			if (sh.containsKey(ch))
				num = sh.get(ch);

			sh.put(ch, num + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			ch = t.charAt(i);
			num = 0;

			if (sh.containsKey(ch))
				num = sh.get(ch);

			num--;

			if (num == 0)
				sh.remove(ch);
			else if (num < 0)
				return false;
			else
				sh.put(ch, num);
		}

		return sh.size() == 0;

	}

}
