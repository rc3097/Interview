package leetcode;
import java.util.ArrayList;

public class Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ArrayList<Integer> num1 = new ArrayList<Integer>();
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		while (l1 != null) {
			num1.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			num2.add(l2.val);
			l2 = l2.next;
		}
		
		if (num1.size()<num2.size()) {
			ArrayList<Integer> temp=num2;
			num2=num1;
			num1=temp;
		}
		
		for (int i = 0; i < num2.size(); i++) {
			num1.set(i,num1.get(i)+num2.get(i));
		}
		
		for (int i = 0; i < num1.size()-1; i++) {
			if (num1.get(i)>9) {
				num1.set(i+1,num1.get(i)/10+num1.get(i+1));
				num1.set(i,num1.get(i) % 10);
			}
		}
		if (num1.get(num1.size()-1)>9) {
			num1.add(num1.get(num1.size()-1)/10);
			num1.set(num1.size()-2,num1.get(num1.size()-2) % 10);
		}
		
		ListNode result=new ListNode(num1.get(0));
		ListNode insert=result;
		for (int i = 1; i < num1.size(); i++) {
			ListNode temp=new ListNode(num1.get(i));
			insert.next=temp;
			insert=temp;
		}
		
		return result;
	}
}
