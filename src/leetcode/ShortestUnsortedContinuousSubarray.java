package leetcode;

import java.util.Arrays;

/**
 * Created by runpeng.chen on 5/18/17.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] ordered_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ordered_nums);
        int left = 0;
        int right = nums.length - 1;
        for (left = 0; left < nums.length && ordered_nums[left] == nums[left]; left++) ;
        if (left == nums.length) return 0;
        for (right = nums.length - 1; right >= 0 && ordered_nums[right] == nums[right]; right--) ;
        return right - left + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{2,  4,6, 8, 10, 9, 15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 2}));
        System.out.println(solution.findUnsortedSubarray(new int[]{}));


    }
}