package leetcode;
import java.util.Arrays;


public class Search_in_Rotated_Sorted_Array {
    public int search(int[] A, int target) {
    	if (A==null) return -1;
    	int left=0;
    	int right=A.length-1;
    	int middle=(left+right)/2;
    	while (A[middle]!=target && right>=left){
    		if (A[middle]>=A[left]) {
    			if (target>=A[left] && target<A[middle]){
        			right=middle-1;
        		} else {
					left=middle+1;
				}
    		} else {
				if (target>A[middle] && target<=A[right]) {
					left=middle+1;
				} else {
					right=middle-1;
				}
			}
    		middle=(left + right) /2;
    	}
    	if (A[middle]==target) return middle;
    	return -1;
    }
}