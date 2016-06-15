package leetcode;
import java.util.HashMap;
import java.util.zip.Inflater;

public class Q219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums==null) return false;
    	HashMap<Integer,Integer> historyHashMap  = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length;i++ ) {
            if (historyHashMap.containsKey(nums[i]) && i-historyHashMap.get(nums[i])<=k) return true;
            historyHashMap.put(nums[i], i);
        }
        return false;
    }
}
