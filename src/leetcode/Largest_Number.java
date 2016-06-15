package leetcode;
import java.util.Arrays;

public class Largest_Number {
	public String largestNumber(int[] nums) {
		if (nums.length==0) return "";
		String[] numsString = new String[nums.length];
		for (int i = 0; i < numsString.length; i++) {
			numsString[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(numsString);
		String result = "";
		int start = 0;
		int end = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == 0
					|| numsString[i].charAt(0) != numsString[i - 1].charAt(0)) {
				start = i;
				for (int j = start; j < end - 1; j++) {
					for (int k = j + 1; k < end; k++) {
						String A = numsString[j]+ numsString[k];
						String B = numsString[k]+ numsString[j];
						if (A.compareTo(B) >= 0) {
							String temp = numsString[j];
							numsString[j] = numsString[k];
							numsString[k] = temp;
						}
					}
				}

				for (int j = end - 1; j >= start; j--) {
					result += numsString[j];
				}
				end = start;

			}
		}
		boolean allzero=true;
		for (int i = 0; i < result.length(); i++) {
			if (!"0".equals(result.charAt(i)+"")) {
				allzero=false;
				return result;
			}
		}
		return "0";
	}
}