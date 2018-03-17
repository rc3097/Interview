package leetcode;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0]==target) return 0;
        int left = 0;
        int right = nums.length-1;
        while (left< right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if ( target < nums[mid]) {
                    right = mid -1 ;
                } else if (target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            } else {
                if (target > nums[mid]) {
                    left = mid+1;
                } else if (target >= nums[left]) {
                    right  = mid -1;
                } else {
                    left = mid+1;
                }
            }
        }
        if (right>=0 && right<nums.length && nums[right] == target) return right;
        if (left>=0 && left<nums.length && nums[left] == target) return left;
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray searchinRotatedSortedArray = new SearchinRotatedSortedArray();
        System.out.println( searchinRotatedSortedArray.search(new int[]{1,3},3));
        System.out.println( searchinRotatedSortedArray.search(new int[]{1,3},1));
        System.out.println( searchinRotatedSortedArray.search(new int[]{3,1},0));
        System.out.println( searchinRotatedSortedArray.search(new int[]{3,1},3));
        System.out.println( searchinRotatedSortedArray.search(new int[]{3,1},1));

    }
}
