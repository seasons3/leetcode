package leetcode;

public class _0109_CovertSortedListToBST {
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		return slow;
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode mid = findMiddle(head);
		TreeNode root = new TreeNode(mid.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}
}
