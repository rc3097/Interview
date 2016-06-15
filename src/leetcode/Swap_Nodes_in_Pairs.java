package leetcode;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
    	if (head==null) return null;
    	ListNode pre=new ListNode(0);
    	pre.next=head;
    	head=pre;
    	ListNode result=head;
    	head=head.next;
        while (head!=null && head.next!=null) {
			ListNode temp=head;
			ListNode tempnextListNode=head.next.next;
			head=head.next;
			pre.next=head;
			head.next=temp;
			head.next.next=tempnextListNode;
			pre=head.next;
			head=head.next.next;
		}
        result=result.next;
        return result;
    }
}