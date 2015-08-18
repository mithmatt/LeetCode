package linkedlist;

import java.util.PriorityQueue;

/**
 * 
 * Problem 23
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author Matt
 *
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode listA = new ListNode(1);
		listA.next = new ListNode(2);
		listA.next.next = new ListNode(4);

		ListNode listB = new ListNode(5);
		listB.next = new ListNode(9);

		ListNode listC = null;

		ListNode listD = new ListNode(4);
		listD.next = new ListNode(7);

		ListNode[] lists = { listA, listB, listC, listD };

		ListNode head = mergeKLists(lists);

		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		int n = lists.length;

		if (n < 1)
			return null;
		else if (n == 1)
			return lists[0];

		PriorityQueue<ListNodeWrapper> minHeap = new PriorityQueue<ListNodeWrapper>(n);

		int i = 0;

		for (i = 0; i < n; i++) {
			if (lists[i] != null) {
				minHeap.add(new ListNodeWrapper(lists[i], i));
				lists[i] = lists[i].next;
			}
		}

		ListNode head = null, prev = null;
		ListNodeWrapper temp = null;

		while (!minHeap.isEmpty()) {
			temp = minHeap.remove();
			i = temp.listNo;

			if (lists[i] != null) {
				minHeap.add(new ListNodeWrapper(lists[i], i));
				lists[i] = lists[i].next;
			}

			if (head == null) {
				head = new ListNode(temp.val);
				prev = head;
			} else {
				prev.next = new ListNode(temp.val);
				prev = prev.next;
			}
		}

		return head;
	}

	private static class ListNodeWrapper implements Comparable<ListNodeWrapper> {
		int val;
		int listNo;

		ListNodeWrapper(ListNode obj, int listNo) {
			this.val = obj.val;
			this.listNo = listNo;
		}

		@Override
		public int compareTo(ListNodeWrapper o) {
			return this.val - o.val;
		}
	}

}
