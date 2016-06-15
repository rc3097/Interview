package leetcode;
import java.util.HashSet;
import java.util.Iterator;

public class Single_Number_II {
    public int singleNumber(int[] nums) {
    	int[] count=new int[32];
    	int result=0;
    	for (int i = 0; i < 32; i++) {
    		for (int j = 0; j < nums.length; j++) {
    			int temp=(nums[j] >> i ) & 1;
				if (((nums[j] >> i ) & 1)==1) {
					count[i]++;
				}
			}
			result |= (count[i] %3)<<i;
		}
    	return result;
    }
}