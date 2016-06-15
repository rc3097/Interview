package leetcode;
public class Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result=new ListNode(0);
		result.next = l1;
		ListNode temp;
		ListNode pre = result;
		while (l1 != null & l2 != null) {
			if (l1.val > l2.val) {
				temp = l2;
				l2=l2.next;
				temp.next=l1;
				pre.next=temp;
				pre=temp;
			} else {
				pre=l1;
				l1=l1.next;
			}
		}
		if (l1==null) {
			pre.next=l2;
		}
		result=result.next;
		return result;
	}
}