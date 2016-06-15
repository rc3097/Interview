package leetcode;
public class Q83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode preone = head;

		while (preone.next != null) {
			ListNode current = preone.next;
			if (current.val == preone.val) {
				preone.next = current.next;
			} else {
				preone = preone.next;
			}
		}
		return head;
	}
}