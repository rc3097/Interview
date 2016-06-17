package leetcode;
public class ListNode {
	  public int val;
	  public ListNode next;
	  public ListNode(int x) {
	      val = x;
	      next = null;
	  }

	  public ListNode (int[] nums) {
	  	ListNode dummyhead = new ListNode(0);
	  	ListNode node = dummyhead;
	  	for (int i=0;i<nums.length;i++) {
	  		node.next = new ListNode(nums[i]);
	  		node =  node.next;
	  	}
	  	this.val = dummyhead.next.val;
	  	this.next = dummyhead.next.next;
	  }

	  public void print() {
	  	System.out.print(val);
	  	ListNode node = this.next;
	  	while (node!=null) {
	  		System.out.print("-->");
	  		node.print();
	  		node = node.next;
	  	}
	  }
}
