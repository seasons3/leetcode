package leetcode;

/**
 * Time complexity : O(max(m,n)). Assume that m and n represents the length of
 * l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
 * 
 * Space complexity : O(max(m,n)). The length of the new list is at most
 * max(m,n)+1.
 * 
 * @author leen
 *
 */
public class _0002_AddTwoNumbers {
	// Initialize dummy node
	// Initialize carry = 0
	// Loop both l1 & l2 until you reach both ends
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int num1 = l1 == null ? 0 : l1.val;
			int num2 = l2 == null ? 0 : l2.val;
			int num = carry + num1 + num2;
			ListNode node = new ListNode(num % 10);
			carry = num / 10;
			cur.next = node;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			cur = cur.next;

		}
		// Do not forget extra carry
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		return dummy.next;

	}
}
