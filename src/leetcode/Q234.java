package leetcode;
public class Q234 {
	public static boolean isPalindrome(ListNode head) {
		int len = 0;
		ListNode pointer = head;
		while (pointer != null) {
			len++;
			pointer = pointer.next;
		}
		if (len < 2)
			return true;
		ListNode reverseNode = null;

		int mid = len / 2;
		pointer = head;
		while (pointer != null) {
			ListNode tempnode = new ListNode(pointer.val);
			tempnode.next = reverseNode;
			reverseNode = tempnode;
			pointer = pointer.next;
		}

		pointer = head;
		for (int i = 0; i < mid; i++) {
			if (reverseNode.val != pointer.val)
				return false;
			reverseNode = reverseNode.next;
			pointer = pointer.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(1);
		head3.next = head4;
		head2.next = head3;
		head.next = head2;
		System.out.println(isPalindrome(head));
	}
}
