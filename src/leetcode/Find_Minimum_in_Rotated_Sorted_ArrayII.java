package leetcode;

public class Find_Minimum_in_Rotated_Sorted_ArrayII {
	public int findMin(int[] num) {
		if (num.length==1) return num[0];
		int left=0;
		int right=num.length-1;
		int min=0;
		while (num[left]==num[left+1] && left+1<right) left++;
		while ((num[right]==num[right-1] || num[right]==num[left]) && left+1<right) right--;
		while (num[left]>=num[right] && (right-left>2)) {
			while (num[left]==num[left+1] && left+1<right) left++;
			while ((num[right]==num[right-1] || num[right]==num[left]) && left+1<right) right--;
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
		int middle=(right+left)/2;
		if (right-left==2) {min=Math.min(num[middle], num[left]); min=Math.min(num[right], min);}
		return min;
	}
}