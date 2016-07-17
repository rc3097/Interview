
package bloomberg;
import java.util.*;
public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {
		TreeLinkNode left,right,next;
	}
	public void connect(TreeLinkNode root) {
		if (root==null || root.left==null) return;
		root.left.next =  root.right;
		root.right.next = (root.next!=null)?root.next.left: null;
		connect(root.left);
		connect(root.right);
	}
}