package leetcode;
public class Find_Minimum_in_Rotated_Sorted_Array {
	public int findMin(int[] num) {
		if (num.length==1) return num[0];
		int left=0;
		int right=num.length-1;
		int min=0;
		while (num[left]>num[right] && (right-left>1)) {
			int middle=(left+right)/2;
			if (num[middle]>num[left] && num[right]<num[left]) {
				left=middle+1;
			} else if (num[middle]<num[right] && num[left]<num[middle]) {
				right=middle-1;
				min=num[left];
				break;
			} else if (num[middle]<num[right] && num[left]>num[middle]) {
				right=middle;
			}
		}
		if (right-left==1) {min=Math.min(num[right], num[left]);}
		if (num[left]<=num[right]) min=num[left];
		return min;
	}
}