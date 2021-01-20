package leetcode;

public class _0142_LinkedListCycle {

	//Assume the distance from head to the start of the loop is x1
	//the distance from the start of the loop to the point fast and slow meet is x2
	//the distance from the point fast and slow meet to the start of the loop is x3
	//x1 + x2 + x3 + x2 faster
	//x1 + x2 slower
	//x1 + x2 + x3 + x2 = 2 (x1 + x2)
	//x1 = x3 head to start == meet to start
	//let slow = head, fast = meet, if slow == fast and moving at the same speed,
	//then the meet point is cycle entry


	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		boolean isCycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isCycle = true;
				break;
			}
		}
		if (!isCycle) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;

	}



}
