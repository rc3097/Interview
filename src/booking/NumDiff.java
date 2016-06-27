package booking;

import java.util.*;

/*
*3. 给一堆数，比如 input ：25400 26300 2 128 5. output：25400 -128 900 -128 -26298 126 -123 题意 只要当前数减去前面数 -127<=diff<=127 就直接输出 diff， 如果不是先输出-128 在输出diff。
* http://www.1point3acres.com/bbs/thread-144112-1-1.html
*/
public class NumDiff {
	public static void getDiff(ArrayList<Long> nums) {
		if (nums.size()==0) return;
		System.out.print(nums.get(0));
		for (int i=1; i< nums.size();i++) {
			long diff = nums.get(i) - nums.get(i-1);
			if (diff>=-127 && diff<=127) {

			} else {
				System.out.print(" ");
				System.out.print(-128);
				
			}
			System.out.println(diff);
		}
	}

	public static void main(String[] args) {
		ArrayList<Long> nums = new ArrayList<Long>();
		Scanner in = new Scanner(System.in);
		while (in.hasNextLong()) {
			nums.add(in.nextLong());
		}
		
		getDiff(nums);
	}
}

