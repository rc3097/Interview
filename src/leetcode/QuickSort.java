package leetcode;
public class QuickSort {
	private class Test{
		int a=0;
	}
	public void quicksort(int[] nums) {
		quicksort(nums,0,nums.length-1);
		Test test = new Test();
		test.a = 1;
		System.out.println(1);
	}

	private void quicksort(int[] nums, int start, int end) {
		if (start>=end) return;
		int l = start;
		int r = end;
		int pivot = nums[end];
		while (true) {
			while (l<r && nums[l]<pivot) l++;
			while (l<r && pivot<=nums[r]) r--;
			if (l==r) break;
			swap(nums, l, r);
		}
		swap(nums, l, end);
		quicksort(nums,start,l-1);
		quicksort(nums,l+1,end);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp; 
	}
}
