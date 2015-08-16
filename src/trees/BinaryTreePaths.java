package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem 257
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author Matt
 *
 */
public class BinaryTreePaths {

	private static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);

		result = binaryTreePaths(root);

		for (String each : result)
			System.out.println(each);
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		getPathRec(root, "");
		return result;
	}

	private static void getPathRec(TreeNode temp, String path) {

		if (temp == null)
			return;

		path += "" + temp.val;

		if (temp.left == null && temp.right == null) {
			result.add(path);
			return;
		}

		if (temp.left != null)
			getPathRec(temp.left, path + "->");

		if (temp.right != null)
			getPathRec(temp.right, path + "->");
	}

}
