package leetcode;
import java.util.ArrayList;


public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
    	if (head==null) return null;
    	ArrayList<Integer> templist=new ArrayList<Integer>();
    	while (head!=null) {
			templist.add(head.val);
			head=head.next;
		}
    	ListNode result=new ListNode(templist.get(0));
    	for (int i=1;i<templist.size(); i++) {
    		ListNode temp=new ListNode(templist.get(i));
    		temp.next=result;
    		result=temp;
    	}
		return result;
    
    }
}
