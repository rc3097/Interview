package bloomberg;

import java.util.*;

import leetcode.ListNode;

public class ReverseListNode{
	public ListNode reverseNode(ListNode head) {
		ListNode dummyhead = new ListNode(0);
		while (head!=null) {
			ListNode nextone = dummyhead.next;
			ListNode nexthead = head.next;
			head.next = nextone;
			dummyhead.next = head;
			head = nexthead;
		}
		return dummyhead.next;
	}

	public ListNode reverseList(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}

	public static void main(String[] args) {
	}
}