package linkedlist;

/**
 * 
 * Problem 24
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author Matt
 *
 */
public class SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);

		head = swapPairs(head);

		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}

	}

	private static ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;

		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode p3 = null, last = null;

		boolean first = true;

		while (p2 != null) {
			if (first)
				head = p2;

			p3 = p2.next;
			p2.next = p1;
			p1.next = p3;

			if (!first)
				last.next = p2;

			last = p1;
			p1 = p3;

			if (p1 != null)
				p2 = p1.next;
			else
				p2 = null;

			first = false;
		}

		return head;
	}

}
