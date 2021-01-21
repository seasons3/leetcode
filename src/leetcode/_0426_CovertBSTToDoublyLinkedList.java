package leetcode;

//successor right
//predecessor left
/**
 * Standard inorder recursion follows left -> node -> right order, 
 * where left and right parts are the recursion calls and 
 * node part is where all processing is done.
 * Processing here is basically to link the previous node with the current one
 * @author leen
 *
 */
public class _0426_CovertBSTToDoublyLinkedList {

	Node first = null;
	Node last = null;

	private void dfs(Node node) {
		if (node == null)
			return;
		dfs(node.left);
		if (last == null) {
			first = node;
		} else {
			last.right = node;
			node.left = last;
		}
		last = node;
		dfs(node.right);

	}

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;
		dfs(root);
		// close doubly Linked list
		// successor of the last element is the first element.
		// predecessor of the first element is the last element.
		last.right = first;
		first.left = last;

		return first;
	}

}
