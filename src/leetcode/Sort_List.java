package leetcode;
public class Sort_List {

	public ListNode getMidnode(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slowListNode = head;
		ListNode fastListNode = head;
		while (fastListNode.next != null && fastListNode.next.next != null) {
			fastListNode = fastListNode.next.next;
			slowListNode = slowListNode.next;
		}
		return slowListNode;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode midnode = getMidnode(head);
		ListNode next = midnode.next;
		midnode.next = null;
		return mergeListNode(sortList(head), sortList(next));
	}

	public ListNode mergeListNode(ListNode first, ListNode second) {
		ListNode fakehead = new ListNode(-1);
		ListNode currentListNode = fakehead;
		while (first != null && second != null) {
			if (first.val <= second.val) {
				currentListNode.next = first;
				first = first.next;
			} else {
				currentListNode.next = second;
				second = second.next;
			}
			currentListNode = currentListNode.next;
		}
		if (first != null) {
			currentListNode.next = first;
		} else {
			currentListNode.next = second;
		}
		return fakehead.next;
	}
}