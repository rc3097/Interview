package leetcode;
import java.awt.HeadlessException;

public class Reorder_List {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		} else {
			ListNode slow = head;
			ListNode fast = head;

			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			ListNode last = slow.next;
			ListNode pre = null;
			while (last != null) {
				ListNode a = last.next;
				last.next = pre;
				pre = last;
				last = a;
			}
			slow.next = pre;

			ListNode mid = slow.next;
			slow.next = null;
			ListNode top = head;
			while (mid != null) {
				ListNode temp = top.next;
				top.next = mid;
				last = mid.next;
				mid.next = temp;
				top = temp;
				mid = last;
			}

		}
	}

}