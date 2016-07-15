/*
*https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
    	int left=0;
    	int right = numbers.length-1;
    	int[] res = new int[2];
    	while (left<right) {
    		if (numbers[left]+numbers[right]<target) {
    			left++;
    		} else if (numbers[left+numbers[right]>target){
    			right--;
    		} else {
    			index[0] = left;
    			index[1] = right;
    			break;
    		}
    	}
    	return index;
    }
}