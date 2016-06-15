package leetcode;
import java.util.HashSet;
import java.util.Iterator;


public class Single_Number {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
        	return (Integer) iterator.next();
        }
        return 0;
    }
}