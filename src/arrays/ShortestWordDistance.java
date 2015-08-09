package arrays;

/**
 * 
 * Problem 243
 * 
 * https://leetcode.com/problems/shortest-word-distance/
 * 
 * @author Matt
 *
 */
public class ShortestWordDistance {

	public static void main(String[] args) {

		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		System.out.println(shortestDistance(words, "makes", "coding"));
	}

	private static int shortestDistance(String[] words, String word1, String word2) {

		int f = -1, s = -1, min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				f = i;
			if (words[i].equals(word2))
				s = i;
			if (f > -1 && s > -1)
				min = Math.min(min, Math.abs(f - s));
		}

		return min;
	}

}
