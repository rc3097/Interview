package leetcode;
public class Q109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null) {
			TreeNode tempnode = new TreeNode(head.val);
			return tempnode;
		}
		ListNode fastnode = head.next.next;
		ListNode slownode = head;
		while (fastnode != null && fastnode.next != null) {
			slownode = slownode.next;
			fastnode = fastnode.next.next;
		}
		ListNode last = slownode.next.next;
		TreeNode root = new TreeNode(slownode.next.val);
		slownode.next = null;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(last);
		return root;
	}
}
