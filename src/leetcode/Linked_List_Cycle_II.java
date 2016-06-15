package leetcode;
import java.util.HashSet;


public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
    	HashSet<ListNode> aHashSet = new HashSet<ListNode>();
    	if (head == null) return null;
    	for (ListNode i=head ; i.next!=null ; i=i.next) {
    		if  (aHashSet.contains(i.next)) {
    			return i.next;
    		} 
			aHashSet.add(i);
		}
		return null;
    }
}