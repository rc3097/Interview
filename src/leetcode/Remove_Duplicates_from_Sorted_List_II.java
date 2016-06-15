package leetcode;
import java.util.Currency;

public class Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode current = head;
		while (current != null && current.next!=null && current.val == current.next.val) {
			boolean isHead = false;
			while (current.next != null && current.val == current.next.val) {
				current = current.next;
				isHead = true;
			}
			if (isHead)
				head = current.next;
			current = head;
		}
		if (head == null)
			return head;
		current = head.next;
		ListNode pre = head;
		while (current != null) {
			boolean isReplicate = false;
			while (current.next != null && current.val == current.next.val) {
				isReplicate = true;
				current = current.next;
			}
			if (isReplicate) {
				pre.next = current.next;
				current = current.next;
			} else {
				pre = current;
				current = current.next;
			}
		}
		return head;
	}
}
