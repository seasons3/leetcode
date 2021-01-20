package leetcode;

public class LinkedList_FindMiddle {
	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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

	// 1, 2, 3, 4, 5
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = buildLinkedList(nums);
		System.out.println(findMiddle(head).val);
		int[] nums2 = { 1, 2, 3, 4, };
		ListNode head2 = buildLinkedList(nums2);
		System.out.println(findMiddle(head2).val);
	}

}
