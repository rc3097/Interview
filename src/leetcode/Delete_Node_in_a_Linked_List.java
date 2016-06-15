package leetcode;

public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}