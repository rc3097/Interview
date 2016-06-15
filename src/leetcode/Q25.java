package leetcode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        int i = 0;
        dummy.next= head;
        ListNode pre = head;
        ListNode ppre = dummy;
        while (head != null) {
            i++;
            if (i % k ==0) {
                ListNode nextone = head.next;
                reverse(pre,head);
                pre.next = nextone;
                ppre.next =head;
                ppre = pre;
                head =nextone;
                pre = head;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    private void reverse(ListNode pre, ListNode end) {
        if (pre == end) {
            return;
        }
        ListNode ppre = pre.next;
        reverse(pre.next,end);
        ppre.next = pre;
        pre.next =null;
    }
}