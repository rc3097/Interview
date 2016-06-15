package leetcode;

public class Insertion_Sort_List {
	public ListNode insertionSortList(ListNode head) {
		if (head==null) {
			return (null);
		}
		ListNode result=new ListNode(head.val);
		while (head.next!=null) {
			head=head.next;
			ListNode temp=result;
			while (temp.next !=null && temp.next.val < head.val) {
				temp=temp.next;
			}
			if (temp.next==null && head.val >= temp.val) {
				ListNode lastone=new ListNode(head.val);
				temp.next=lastone;
			} else if (temp.next!=null && head.val >= temp.val && head.val<= temp.next.val) {
				ListNode interNode=new ListNode(head.val);
				interNode.next=temp.next;
				temp.next=interNode;
			} else if (head.val<temp.val) {
				ListNode headerNode=new ListNode(head.val);
				headerNode.next=temp;
				result=headerNode;
			}
		}
		return result;
	}
}
