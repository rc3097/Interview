package leetcode;
public class EncodeDecode {
	public String encode(String s) {
		int start = 0;
		String res = "";
		while (start < s.length()) {
			int end = start;
			int num = 0;
			while (end == start
					|| (end < s.length() && s.charAt(end) == s.charAt(end - 1))) {
				end++;
				num++;
			}
			char target = s.charAt(start);
			if (num > 1 || (s.charAt(start) >= '0' && s.charAt(start) <= '9')) {
				res += String.valueOf(num) + "*" + target;
			} else {
				res += target;
			}
			start = end;
		}
		return res;
	}

	public String decode(String s) throws Exception {
		int start = 0;
		String res = "";
		while (start < s.length()) {
			if (s.charAt(start) >= '0' && s.charAt(start) <= '9') {
				int end = start;
				String num_s = "";
				while (s.charAt(end) >= '0' && s.charAt(end) <= '9') {
					num_s += s.charAt(end);
					end++;
				}
				int num = Integer.valueOf(num_s);
				if (s.charAt(end) != '*')
					throw new Exception("it is wrong format");
				end ++;
				char target = s.charAt(end);
				for (int i  = 0; i<num;i++) {
					res+=target;
				}
				start = end;
			} else {
				res += s.charAt(start);
			}
			start++;
		}
		return res;
	}
}
