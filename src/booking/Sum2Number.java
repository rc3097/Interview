package booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Sum2Number {
	public static int getPair(Long target, ArrayList<Long> nums) {
		HashMap<Long, Integer> numMap = new HashMap();

		for (Long num : nums) {
			int count = 0;
			if (numMap.containsKey(num)) {
				count = numMap.get(nums);
			}
			count++;
			numMap.put(num, count);
		}
		for (Long num : nums) {
			int count = numMap.get(num);
			count--;
			numMap.put(num, count);
			if (numMap.containsKey(target - num)
					&& numMap.get(target - num) > 0) {
				return 1;
			} 
			count++;
			numMap.put(num, count);
		}
		return 0;
	}

	public static void main(String args[]) throws Exception {
		ArrayList<Long> nums = new ArrayList();
//		Long target = (long) 66;
//		nums.add((long) 10);
//		nums.add((long) 18);
//		nums.add((long) 11);
//		nums.add((long) 21);
//		nums.add((long) 28);
//		nums.add((long) 31);
//		nums.add((long) 38);
//		nums.add((long) 40);
//		nums.add((long) 55);
//		nums.add((long) 60);
//		nums.add((long) 62);

		Scanner in = new Scanner(System.in);
		Long target = in.nextLong();
		while (in.hasNextLong()) {
			nums.add(in.nextLong());
		}
		System.out.println(getPair(target, nums));
	}
}

