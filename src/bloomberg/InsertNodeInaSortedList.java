
package  bloomberg;

import leetcode.ListNode;

/*
* insert node  in a sorted list
*/
public class InsertNodeInaSortedList {
	public ListNode insert(ListNode head, int num) {
		if (head==null) {
			return new ListNode(num);
		}
		ListNode dummyhead =  new ListNode(0);
		dummyhead.next = head;
		ListNode pre =  dummyhead;
		ListNode root =  head;
		while (root!=null && root.val<num) {
			pre = root;
			root = root.next;
		}

		ListNode numNode = new ListNode(num);
		ListNode temp = pre.next;
		pre.next = numNode;
		numNode.next = temp;
		return dummyhead.next;
	}
}