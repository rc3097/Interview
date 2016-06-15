package leetcode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q39 {
	   public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        HashMap<Integer, List<List<Integer>>> targetmap = new HashMap<Integer, List<List<Integer>>>();
	        ArrayList<Integer> initialList= new ArrayList<Integer>();
	        ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
	        temp.add(initialList);
	        targetmap.put(0, temp);
	        List<List<Integer>> results = getSubset(targetmap,candidates, 0, target);
	        return results;
	    }
	    
	    private List<List<Integer>> getSubset(HashMap<Integer, List<List<Integer>>> targetmap,int[] candidates, int start,int target) {
	        if (targetmap.containsKey(target)) {
	            return targetmap.get(target);
	        }
	        List<List<Integer>>  result = new ArrayList<List<Integer>>();
	        for (int i = start; i<candidates.length;i++) {
	            int num = candidates[i];
	            if (target>=num) {
	                List<List<Integer>> subset = getSubset(targetmap,candidates,i,target- num);
	                for (List<Integer> set:subset) {
	                    List<Integer> tempset = new ArrayList<Integer>(set);
	                    tempset.add(0,num);
	                    result.add(tempset);
	                }
	            } else {
	                break;
	            }
	        }
	        return result;
	    } 
	}
