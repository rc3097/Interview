package leetcode;
import java.util.Arrays;
import java.util.Comparator;

public class Q14 {
	@SuppressWarnings("unchecked")
	public String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs, new Comparator() {
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((String) o1).length() - ((String) o2).length();
			}
		});
		String result = "";
		int index = 0;
		while (true) {
			if (index>=strs[0].length()) 
			{
				return strs[0];
			}
			String tempString = result + strs[0].charAt(index);
			for (String string : strs) {
				if (!string.startsWith(tempString)) {
					return result;
				}
			}
			result = tempString;
			index++;
		}

	}
}