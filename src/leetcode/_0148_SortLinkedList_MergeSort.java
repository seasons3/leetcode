package leetcode;

public class _0148_SortLinkedList_MergeSort {

	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		return slow;
		// must use prev to mark prev.next = null;
		// if not using prev
		// ListNode right = sortList(mid.next);
		// mid.next = null;
		// ListNode left = sortList(head);
		// if only 2 nodes will cause infinite loop
		// e.g 4,2 find mid is 2. for mid.next is already null. ListNode left =
		// sortList(head)
		// head again is 4, 2
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return dummy.next;
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddle(head);
		ListNode right = sortList(mid);
		ListNode left = sortList(head);
		return merge(left, right);

	}

	private static ListNode buildLinkedList(int[] nums) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2 };
		sortList(buildLinkedList(nums));

	}
}
