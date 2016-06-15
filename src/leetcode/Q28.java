package leetcode;
public class Q28 {
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		char[] chr = haystack.toCharArray();
		char[] needlechr = needle.toCharArray();
		for (int i = 0; i < chr.length - needlechr.length+1; i++) {
			boolean exist = true;
			for (int j = 0; j < needlechr.length; j++) {
				if (needlechr[j] != chr[i + j]) {
					exist = false;
					break;
				}
			}
			if (exist)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(strStr("123", "23"));
	}
}
