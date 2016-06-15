package leetcode;
public class Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null || head.next == null)
			return head;
		ListNode result = head;
		ListNode pre = null;
		while (result != null) {
			if (result.val == val) {
				pre.next = result.next;
				result=pre.next;
			} else {
				pre = result;
				result = pre.next;
			}
		}

		return head;
	}
}