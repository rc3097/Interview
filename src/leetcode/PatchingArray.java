package leetcode;
import java.util.Arrays;


public class PatchingArray {
	   public int minPatches(int[] nums, int n) {
	        boolean[] sum = new boolean[n+1];
	        Arrays.fill(sum,false);
	        sum[0]=true;
	        for (int num:nums) {
	            for (int j=n;j>=0;j--){
	                if (j+num<=n && sum[j]) {
	                    sum[j+num]=true;
	                }
	            }
	        }
	        
	        int count=0;
	        int miss;
	        do {
	            miss = checkall(sum);
	            if (miss!=Integer.MAX_VALUE) {
	                count++;
	                for (int j=n;j>=0;j--) {
	                    if (j+miss<=n && sum[j]) {
	                        sum[j+miss]=true;
	                    }
	                }
	            }
	        } while (miss!=Integer.MAX_VALUE);
	        return count;
	    }
	    
	    private int checkall(boolean[] sum) {
	        for (int i=0;i<sum.length;i++) {
	            if (sum[i]==false) return i;
	        }
	        return Integer.MAX_VALUE;
	    }
	}