package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class MinimumHeightTrees {
	   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        ArrayList<HashSet<Integer>> edgelist = new ArrayList<HashSet<Integer>>();
	        for (int i=0;i<n;i++) edgelist.add(new HashSet<Integer>());
	        for (int[] edge:edges) {
	            edgelist.get(edge[0]).add(edge[1]);
	            edgelist.get(edge[1]).add(edge[0]);
	        }
	        Queue<Integer> queue = new LinkedList<Integer>();
	        
	        for (int i=0; i<n;i++) {
	            if (edgelist.get(i).size()==1) {
	                queue.add(i);
	            }
	        }
	        int count =0;
	        
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            count++;
	            HashSet<Integer> edgeset = edgelist.get(node);
	            for (int tonode:edgeset) {
	                edgelist.get(tonode).remove(node);
	                if (edgelist.get(tonode).size()==1) {
	                    queue.add(tonode);
	                }
	            }
	        }
	        List<Integer> res = new ArrayList<Integer>();
	        for (int i =0;i<n;i++) {
	            if (edgelist.get(i).size()!=0) 
	                res.add(i);
	        }
	            
	        return res;
	    }
	}