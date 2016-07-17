package snapchat;
import java.util.*;

import utils.TreeNode;

public class BTtoDLL {
	TreeNode prev = null;
	public void transform(TreeNode root) {
		if (root==null) return;
		transform(root.left);
		root.left = prev;
		if (prev!=null) {
			prev.right = root;
		}
		prev = root;
		transform(root.right);
	}
}