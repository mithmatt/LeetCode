package stack;
import java.util.Stack;

/**
 * 
 * Problem 20
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author Matt
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}

	private static boolean isValid(String s) {
		if (s == null)
			return false;

		Stack<Character> myStack = new Stack<Character>();
		char curr;

		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);

			if (curr == '(' || curr == '{' || curr == '[')
				myStack.push(curr);
			else if (curr == ')' && !myStack.isEmpty() && myStack.peek() == '(')
				myStack.pop();
			else if (curr == '}' && !myStack.isEmpty() && myStack.peek() == '{')
				myStack.pop();
			else if (curr == ']' && !myStack.isEmpty() && myStack.peek() == '[')
				myStack.pop();
			else
				return false;
		}

		return myStack.isEmpty();
	}
}
