package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountofRangeSum {
	private class RangeSum {
		long sum = 0;
		int idx = 0;

		public RangeSum(long sums, int idx) {
			this.sum = sums;
			this.idx = idx;
		}
	}

	long[] sums;
	ArrayList<RangeSum> sortedSums = new ArrayList<CountofRangeSum.RangeSum>();

	public int countRangeSum(int[] nums, int lower, int upper) {
		getSum(nums);
		int result =0;
		for (int i = 0; i < nums.length; i++) {
			int count = getRange(sortedSums, lower, upper, i);
			result+=count;
		}
		return result;
	}

	private int getRange(ArrayList<RangeSum> sortedSums, int lower, int upper,
			int index) {
		int lboundary = rBinarySearch(sortedSums, lower, index);
		int rboundary = lBinarySearch(sortedSums, upper, index);
		int count = 0;
		for (int i = lboundary; i <= rboundary; i++) {
			if (sortedSums.get(i).idx > index) {
				count++;
			}
		}
		return count;
	}

	private int lBinarySearch(ArrayList<RangeSum> sortedSums, int upper,
			int index) {
		// TODO Auto-generated method stub
		long target = sums[index] + upper;
		int l = 0;
		int r = sortedSums.size() - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (sortedSums.get(mid).sum <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r;
	}

	private int rBinarySearch(ArrayList<RangeSum> sortedSums, int lower,
			int index) {
		long target = sums[index] + lower;
		int l = 0;
		int r = sortedSums.size() - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (sortedSums.get(mid).sum >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	private void getSum(int[] nums) {
		sums = new long[nums.length + 1];
		sums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
			sortedSums.add(new RangeSum(sums[i + 1], i + 1));
		}
		Collections.sort(sortedSums, new Comparator<RangeSum>() {
			public int compare(RangeSum o1, RangeSum o2) {
				return (int)(o1.sum - o2.sum);
			}
		});
	}
}
