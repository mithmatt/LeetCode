package numbers;

/**
 * 
 * Problem 258
 * 
 * https://leetcode.com/problems/add-digits/
 * 
 * @author Matt
 *
 */
public class AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(65536));
	}

	private static int addDigits(int num) {
		return (int) (num - 9 * Math.floor((num - 1) / 9));
	}
}
