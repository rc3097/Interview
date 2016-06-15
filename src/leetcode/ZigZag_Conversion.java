package leetcode;
public class ZigZag_Conversion {

	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		int gap = 2 * numRows - 2;
		String result = "";
		int current = 0;
		while (current < s.length()) {
			result += s.charAt(current);
			current += gap;
		}
		for (int i = 2; i < gap; i = i + 2) {
			int start = i / 2;
			current = start;
			int step = gap - i;
			while (current < s.length()) {
				result += s.charAt(current);
				current += step;
				step = gap - step;
			}
		}
		current = numRows - 1;
		while (current < s.length()) {
			result += s.charAt(current);
			current += gap;
		}
		return result;
	}
}