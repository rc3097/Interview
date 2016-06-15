package leetcode;
public class Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
		if (head==null) {return false;}
		ListNode rabbit=head;
		ListNode turtle=head;
		while (rabbit.next!=null && rabbit.next.next!=null && turtle.next!=null) {
			turtle=turtle.next;
			rabbit=rabbit.next.next;
			if (turtle==rabbit) {
				return true;
			}
		}
		return false;
	}
}