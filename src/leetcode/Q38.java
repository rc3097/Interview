package leetcode;
import java.util.ArrayList;

public class Q38 {
	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String result = "1";
		for (int j = 0; j < n-1; j++) {
			String tempresult = "";
			int begin = 0, count = 1;
			for (int i = 1; i < result.length(); i++) {
				if (result.charAt(i - 1) != result.charAt(i)) {
					tempresult += String.valueOf(count) + result.charAt(i - 1);
					count = 1;
				} else {
					count++;
				}
			}
			tempresult += String.valueOf(count) + result.charAt(result.length() - 1);
			result = tempresult;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
}