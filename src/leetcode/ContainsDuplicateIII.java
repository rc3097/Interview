package leetcode;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		SortedSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			SortedSet<Long> subset =set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
			if (!subset.isEmpty())
				return true;
			set.add((long)nums[i]);
			if (i>=k) {
				set.remove(nums[i-k]);
			}
		}
		return false;
	}
}