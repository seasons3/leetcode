package leetcode;

public class _0237_DeleteNodeInLinkedList {
	// 1-->2-->3->4
	// delete Node 2 copy 3 to 2 then 2.next point to 4
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;

	}
}
