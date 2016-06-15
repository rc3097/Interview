package leetcode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reverse_Words_in_a_String {
	public String reverseWords(String s) {
		// String pattern = "(\\s+)";
		// Pattern r = Pattern.compile(pattern);
		// Matcher m = r.matcher(s);
		// if (m.find()) {
		// for (int i = 0; i < m.group().length(); i++) {
		// s=s.replaceFirst(m.group(i).toString(), " ");
		// }
		// }
		s = s.trim();
		String[] splitStrings = s.split(" ");
		String result = "";
		for (int i = 0; i < splitStrings.length; i++) {
			if (!splitStrings[splitStrings.length - 1 - i].equals("")) {
				result += splitStrings[splitStrings.length - 1 - i] + " ";
			}
		}
		result = result.trim();
		return result;
	}
}
