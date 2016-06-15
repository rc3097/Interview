package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        HashMap<Integer,HashMap<Integer, ArrayList<TreeNode>>> memo = new HashMap<Integer,HashMap<Integer, ArrayList<TreeNode>>>();
       return genTree(1,n, memo);
   }
   
   private ArrayList<TreeNode> genTree(int start, int end, HashMap<Integer,HashMap<Integer, ArrayList<TreeNode>>> memo) {
       if (start>end) {
           ArrayList<TreeNode> temparr = new ArrayList<TreeNode>();
           temparr.add(null);
           return temparr;
       }
       if (memo.containsKey(start) && memo.get(start).containsKey(end)) {
           return memo.get(start).get(end);
       }
       if (start==end) {
           TreeNode cur = new TreeNode(start);
           HashMap<Integer, ArrayList<TreeNode>> tempmap = new HashMap<Integer, ArrayList<TreeNode>>();
           ArrayList<TreeNode> temparr = new ArrayList<TreeNode>();
           temparr.add(cur);
           tempmap.put(end,temparr);
           memo.put(start,tempmap);
           return temparr;
       }
       ArrayList<TreeNode> alltype = new ArrayList<TreeNode>();
       for (int i= start; i<=end;i++) {
           ArrayList<TreeNode> rootleft = genTree(start,i-1,memo);
           ArrayList<TreeNode> rootright = genTree(i+1,end,memo);
           for (TreeNode left: rootleft)  {
               for (TreeNode right: rootright) {
                   TreeNode root = new TreeNode(i);
                   root.left = left;
                   root.right = right;
                   alltype.add(root);
               }
           }
       }
       
       HashMap<Integer, ArrayList<TreeNode>> subMap = new HashMap<Integer, ArrayList<TreeNode>>();
       subMap.put(end, alltype);
       memo.put(start,subMap);
       return alltype;
   }
}