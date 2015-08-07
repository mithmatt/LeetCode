package linkedlist;

/**
 * 
 * Problem 2
 * 
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author Matt
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode l3 = addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.print(l3.val + " --> ");
			l3 = l3.next;
		}
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null && l2 != null)
			return l2;
		else if (l1 != null && l2 == null)
			return l1;
		else {

			int carry = 0, sum = 0;

			boolean firstTime = true;

			ListNode temp = null, head = null;

			while (l1 != null && l2 != null) {

				sum = l1.val + l2.val + carry;
				carry = sum / 10;
				sum %= 10;

				if (firstTime) {
					head = new ListNode(sum);
					temp = head;
					firstTime = false;
				} else {
					temp.next = new ListNode(sum);
					temp = temp.next;
				}

				l1 = l1.next;
				l2 = l2.next;
			}

			while (l1 != null) {
				sum = l1.val + carry;
				carry = sum / 10;
				sum %= 10;

				temp.next = new ListNode(sum);
				temp = temp.next;

				l1 = l1.next;
			}

			while (l2 != null) {
				sum = l2.val + carry;
				carry = sum / 10;
				sum %= 10;

				temp.next = new ListNode(sum);
				temp = temp.next;

				l2 = l2.next;
			}

			if (carry > 0)
				temp.next = new ListNode(carry);

			return head;
		}
	}

}
