package leetcode;
import java.util.HashMap;


public class HouseRobberIII {
	    public int rob(TreeNode root) {
	        HashMap<TreeNode, int[]> robMap = new HashMap<TreeNode,int[]>();
	        return Math.max(bestrob(robMap,1,root),bestrob(robMap,0,root));
	    }
	    //0 is rob, 1 is not
	    private int bestrob(HashMap<TreeNode, int[]> robMap, int robnot, TreeNode root) {
	        if (root==null) return 0;
	        if (robMap.containsKey(root)) {
	            int[] robarr = robMap.get(root);
	            if (robarr[robnot]!=0) {
	                return robarr[robnot];
	            } 
	        }
	        int[] robarr = new int[2];
	        int notrobleft = bestrob(robMap, 1, root.left);
	        int notrobright = bestrob(robMap,1, root.right);
	        
	        int robleft = bestrob(robMap,0,root.left);
	        int robright = bestrob(robMap,0, root.right);
	        robarr[0] = notrobleft+ notrobright+root.val;
	        robarr[1] = Math.max(notrobleft,robleft)+Math.max(robright,notrobright);
	        
	        robMap.put(root,robarr);
	        return robarr[robnot];
	    }
	}