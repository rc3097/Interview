package snapchat;
import java.util.*;

/*
nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
    	int j = 0;
    	for (int i=0; i< nums.length;i++)  {
    		if (nums[i]!=0) 
    			nums[j++]=nums[i];
    	}
    	for (;j<nums.length;j++) 
    		nums[j]=0;
    }
}