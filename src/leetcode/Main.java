package leetcode;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeSet;

import javax.print.DocFlavor.STRING;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// tree
		TreeNode rootNode = new TreeNode(3);
		TreeNode lNode = new TreeNode(2);
		TreeNode rNode = new TreeNode(3);
		TreeNode llNode = new TreeNode(11);
		TreeNode lrNode = new TreeNode(3);
		// TreeNode lrlNode = new TreeNode(7);
		// TreeNode lrrNode = new TreeNode(4);
		// TreeNode lllNode = new TreeNode(7);
		// TreeNode llrNode = new TreeNode(2);
		// TreeNode rlNode = new TreeNode(13);
		TreeNode rrNode = new TreeNode(1);
		// TreeNode rrlNode = new TreeNode(5);
		// TreeNode rrrNode = new TreeNode(1);
		//
		rootNode.left = lNode;
		rootNode.right = rNode;
		lNode.left = llNode;
		lNode.right = lrNode;
		// lrNode.left = lrlNode;
		// lrNode.right = lrrNode;
		// llNode.left= lllNode;
		// llNode.right = llrNode;
		// rNode.left = rlNode;
		rNode.right = rrNode;
		// rrNode.left = rrlNode;
		// rrNode.right = rrrNode;

		// ListNode head = new ListNode(4);
		// ListNode head2 = new ListNode(2);
		// ListNode head3 = new ListNode(3);
		// ListNode head4 = new ListNode(5);
		// ListNode head5 = new ListNode(9);
		// head4.next = head5;
		// head3.next = head4;
		// head2.next = head3;
		// head.next = head2;
		// BS q = new BS();
		// System.out.println(q.a_lbinarysearch(new
		// int[]{1,2,3,4,4,4,4,4,4,4,6}, 4)); //5 //3 for r maybe +1 to check if
		// they are same.
		// System.out.println(q.a_lbinarysearch(new int[]{1,2,3,4,4,4,6}, 5));
		// //5
		// System.out.println(q.a_lbinarysearch(new int[]{1,2,3,4,4,4,6}, 6));
		// //6
		// System.out.println(q.a_lbinarysearch(new int[]{1,1,1,1}, 1)); //0
		// System.out.println(q.a_lbinarysearch(new int[]{0,1,1,1,1,2}, 1)); //0
		// System.out.println(q.lbinarysearch(new int[]{0,0,1,1,1,1,2}, 0)); //0
		
		WordLadderII q = new WordLadderII();
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		q.findLadders("hit", "cog", set);
	}
}
