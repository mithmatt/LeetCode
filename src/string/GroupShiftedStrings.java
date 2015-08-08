package string;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * Problem 249
 * 
 * https://leetcode.com/problems/group-shifted-strings/
 * 
 * @author Matt
 *
 */
public class GroupShiftedStrings {

	static HashSet<String> setOfStrings = new HashSet<String>();
	static HashMap<String, ArrayList<String>> resultMap = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {

		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };

		for (List<String> eachSet : groupStrings(strings))
			System.out.println(eachSet.toString());
	}

	public static List<List<String>> groupStrings(String[] strings) {
		for (String each : strings)
			setOfStrings.add(each);

		ArrayList<String> temp = null;
		String start = null;

		for (String each : strings) {

			temp = null;
			start = shift(each);

			if (resultMap.containsKey(start))
				temp = resultMap.get(start);

			if (temp == null)
				temp = new ArrayList<String>();

			temp.add(each);
			resultMap.put(start, temp);
		}

		List<List<String>> result = new ArrayList<List<String>>();

		for (ArrayList<String> group : resultMap.values()) {
			Collections.sort(group);
			result.add(group);
		}

		return result;
	}

	private static String shift(String str) {
		int shift = str.charAt(0) - 'a';

		if (shift == 0)
			return str;

		char[] chArray = str.toCharArray();

		for (int i = 0; i < chArray.length; i++) {
			chArray[i] -= shift;
			if (chArray[i] < 'a')
				chArray[i] += 26;
		}

		return new String(chArray);
	}
}
