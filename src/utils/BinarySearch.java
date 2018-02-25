package utils;

import java.util.Arrays;

/**
 * Created by runpeng.chen on 6/27/17.
 */
public class BinarySearch {

    public void findNum(int[] nums, int target) {
        System.out.println(String.format("%s, target: %s, first element match: %s, last element: %s", Arrays.toString(nums), target, first_binarysearch(nums, 0, nums.length - 1, target), last_binarysearch(nums, 0, nums.length - 1, target)));
    }

    private int last_binarysearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int first_binarysearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        BinarySearch q = new BinarySearch();
        q.findNum(new int[]{1, 2, 3, 4, 6}, 2);
        q.findNum(new int[]{1, 2, 2, 3, 3, 3, 4, 6}, 3);
        q.findNum(new int[]{1, 2, 2, 3, 3, 3, 4, 6}, 1);
        q.findNum(new int[]{1, 2, 2, 3, 3, 3, 4, 6}, 0);
        q.findNum(new int[]{1, 2, 2, 3, 3, 3, 4, 6}, 6);
        q.findNum(new int[]{1, 2, 2, 3, 3, 3, 4, 6}, 9);

    }
}
