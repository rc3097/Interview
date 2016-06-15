package leetcode;
public class Q86 {
	public ListNode partition(ListNode head, int x) {
		ListNode smallnode = new ListNode(0);
		ListNode smallhead = smallnode;
		ListNode bignode = new ListNode(0);
		ListNode bighead = bignode;
		while (head != null) {
			if (head.val < x) {
				smallnode.next = head;
				smallnode = smallnode.next;
			} else {
				bignode.next = head;
				bignode = bignode.next;
			}
			head = head.next;
		}
		bighead = bighead.next;
		bignode.next = null;

		smallnode.next = bighead;
		smallhead = smallhead.next;
		return smallhead;
	}
}
