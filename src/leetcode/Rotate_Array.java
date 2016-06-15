package leetcode;
import java.util.Arrays;



public class Rotate_Array {
	  public void rotate(int[] nums, int k) {
          int[] res = new int[nums.length];
          for(int i=0;i<nums.length;i++){
              int offset = k%nums.length;
              res[i] = nums[(i+nums.length-offset)%(nums.length)];
          }
          for(int i=0;i<nums.length;i++){
             nums[i] = res[i];
          }
      }
}