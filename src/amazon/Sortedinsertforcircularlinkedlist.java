package amazon;

import leetcode.ListNode;

/*
 * 给出一个已经排序的循环链表，往里面插入一个节点。
 */
public class Sortedinsertforcircularlinkedlist {
	public ListNode sortedInsert(ListNode head, int target) {
		if (head==null) {
			ListNode node = new ListNode(target);
			node.next = node;
			return node;
		}
		ListNode node = head;
		ListNode pre = head;
		while (node.next != head) node = node.next;
		pre = node;
		node = head;
		while (node.next!=head && target>=node.val) {
			pre = node;
			node = node.next;
		}

		ListNode tNode =  new ListNode(target);

		pre.next = tNode;
		tNode.next = node;
		return node == head && tNode.val<head.val? tNode:head;
	}

	public static void print(ListNode head)  {
		ListNode node = head; 
		while (node.next!=head) {
			System.out.print(node.val+"--> ");
			node = node.next;
		}
		System.out.println(node.val);
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(new int[]{1,2,3,4,4,7,7,8,10});
		ListNode end = head;
		while (end.next!=null) end=end.next;
		end.next = head;
		Sortedinsertforcircularlinkedlist q = new Sortedinsertforcircularlinkedlist();
		head= q.sortedInsert(head, 0);
		print(head);
		head = q.sortedInsert(head,4);
		print(head);
		head =q.sortedInsert(head,11);
		print(head);
		
		head = null;
		head = q.sortedInsert(head, 1);
		print(head);
		head= q.sortedInsert(head, 2);
		print(head);
		head = null;
		head = q.sortedInsert(head, 1);
		head =q.sortedInsert(head, 0);
		head =q.sortedInsert(head, 0);
		print(head);
	}
}
