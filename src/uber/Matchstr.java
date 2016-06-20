package uber;


/*
 * The matching should cover the entire input string (not partial).
 The function prototype should be:
 bool isMatch(String str, String patter)
 Some examples:.
 isMatch("aa","a") → false
 isMatch("aa","aa") → true.
 isMatch("aaa","aa") → false
 isMatch("aa","a{1,3}") → true
 isMatch("aaa","a{1,3}") → false
 isMatch("ab","a{1,3}b{1,3}") → true
 isMatch("abc","a{1,3}b{1,3}c") → true
 isMatch("abbc","a{1,3}b{1,2}c") → false
 isMatch("acbac","a{1,3}b{1,3}c") → false. 
 isMatch("abcc","a{1,3}b{1,3}cc{1,3}") → true
 前面那个字母的range，不包括3，a｛1，3｝＝＝ a ｜｜ aa
 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=188883&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class Matchstr {
	public boolean isMatch(String str, String pattern) {
		if (str.length() == 0 && pattern.length() == 0)
			return true;
		
		if (pattern.length() > 2 && pattern.charAt(1) == '{') {
			char chr = pattern.charAt(0);
			int j = 3;
			int start = 3;
			while (pattern.charAt(j) != ',')
				j++;
			int min = Integer.valueOf(pattern.substring(2, j));
			start = ++j;
			while (pattern.charAt(j) != '}')
				j++;
			int max = Integer.valueOf(pattern.substring(start, j));
			String restr = pattern.substring(j + 1);
			if (min == 0 && isMatch(str, restr))
				return true;
			for (int i = 1; i < max; i++) {
				restr = chr + restr;
				if (i >= min && isMatch(str, restr)) {
					return true;
				}
			}
		} else {
			if (str.length()>0 && pattern.length()>0 && str.charAt(0) == pattern.charAt(0))
				return isMatch(str.substring(1), pattern.substring(1));
			else
				return false;
		}
		return false;
	}

	public static void main(String[] args) {
		Matchstr q = new Matchstr();
		System.out.println(q.isMatch("aa", "a"));
		System.out.println(q.isMatch("aa", "aa"));
		System.out.println(q.isMatch("aaa", "aa"));
		System.out.println(q.isMatch("aaa", "a{1,3}"));
		System.out.println(q.isMatch("aa", "a{1,3}"));
		System.out.println(q.isMatch("ab","a{1,3}b{1,3}"));
		System.out.println(q.isMatch("abc","a{1,3}b{1,3}c"));
		System.out.println(q.isMatch("abbc","a{1,3}b{1,2}c"));
		System.out.println(q.isMatch("acbac","a{1,3}b{1,3}c"));
		System.out.println(q.isMatch("abcc","a{1,3}b{1,3}cc{1,3}"));
		
	}
}
