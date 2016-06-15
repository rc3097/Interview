package leetcode;
public class Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
		if (s == null || s == "") {
			return 0;
		}
		s = s.trim();
		int lastone = s.lastIndexOf(" ");
		if (lastone > -1) {
			return s.substring(lastone + 1, s.length()).length();
		} else
			return s.length();
	}
}
