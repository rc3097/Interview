package snapchat;

import java.util.*;

public class RangeSumQuery {
	int[] bis;
	int[] nums;
	public RangeSumQuery(int[] nums) {
		bis = new int[nums.length+1];
		for (int i = 0; i<nums.length;i++) 
			update(i,nums[i]);
	}

	public void update(int i , int val) {
		int diff = val- nums[i];
		nums[i] = val;
		for (int j =i+1 ; j <= nums.length; j += j & (-j)) {
			bis[j]+=diff;
		}
	}

	public int sum(int i , int j) {
		return getSum(j)-getSum(i-1);
	}

	public int getSum(int i) {
		int sum =0;
		for (int j = i+1; i>0; j-= j & (-j)) 
			sum+=bis[j];
		return sum;
	}

	public static void main(String[] args) {
		RangeSumQuery q = new RangeSumQuery(new int[]{1,2,3,4,5,6});
		System.out.println(q.sum(0,1));
		q.update(1,2);
		System.out.println(q.sum(0,2));

	}
}