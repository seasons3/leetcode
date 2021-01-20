package leetcode;

/**
 * 找到倒数第K个节点
 * 
 * @author leen
 *
 */
public class LinkedList_FindLastKthNode {
// 1->2->3->4->5 if k is 2, 4 is the node we need to find
// i-----j
//          i--> j
// 两个指针隔开k个位置，相同速度移动快慢指针直到快指针出界，慢指针停留在倒数第k个节点
	private static ListNode findLastKthNode(ListNode head, int k) {
		ListNode slow = head, fast = head;
		//move fast pointer k steps forward ahead of slow
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		// move both slow and fast one step forward at a time until fast 
		// is out of bound
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
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
		System.out.println(findLastKthNode(head, 2).val);
	}

}
