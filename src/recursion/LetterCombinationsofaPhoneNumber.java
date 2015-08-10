package recursion;
import java.util.*;

/**
 * 
 * Problem 17
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author Matt
 *
 */
public class LetterCombinationsofaPhoneNumber {
	static ArrayList<String> decoding;
	static ArrayList<String> result = new ArrayList<String>();

	public static void main(String[] args) {

		List<String> res = letterCombinations("3");

		for (String each : res)
			System.out.println(each);
	}

	private static List<String> letterCombinations(String digits) {

		decoding = new ArrayList<String>();
		decoding.add("abc");
		decoding.add("def");
		decoding.add("ghi");
		decoding.add("jkl");
		decoding.add("mno");
		decoding.add("pqrs");
		decoding.add("tuv");
		decoding.add("wxyz");

		recFun("", digits);

		return result;
	}

	private static void recFun(String done, String notdone) {
		if (notdone.length() == 0) {
			result.add(done);
			return;
		}

		int x = Integer.parseInt("" + notdone.charAt(0));
		if (x > 1 && x < 10) {
			char[] ch = decoding.get(x - 2).toCharArray();

			for (int i = 0; i < ch.length; i++) {
				recFun(done + ch[i], notdone.substring(1));
			}
		}
	}
}
