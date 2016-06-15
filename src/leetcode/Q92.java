package leetcode;
public class Q92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		head = fakehead;
		ListNode temphead = head;
		for (int i = 0; i < m - 1; i++)
			temphead = temphead.next;
		ListNode prenode = temphead;
		temphead = temphead.next;
		ListNode current = null;
		for (int i = m; i < n + 1; i++) {
			ListNode nextnode = temphead.next;
			temphead.next = current;
			current = temphead;
			temphead = nextnode;
		}
		prenode.next = current;
		while (current.next != null)
			current = current.next;
		current.next = temphead;
		return fakehead.next;
	}
}
