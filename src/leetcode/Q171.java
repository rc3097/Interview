package leetcode;
public class Q171 {
	public int titleToNumber(String s) {
		int result = 0;
		int base = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			int num = ((int) s.charAt(i) - 64) * base;
			base *= 26;	
			result += num;
		}
		return result;
	}
}
