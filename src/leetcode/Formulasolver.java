package leetcode;
import javax.naming.spi.DirStateFactory.Result;

public class Formulasolver {
	public double formula(String s, int t) {
		return 0;
	}

	public String subformula(String s) {
		if (!s.contains("a")) {
			String res = String.valueOf(cal_s(s));
		}
		return null;
	}

	private int cal_s(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[] findsubformula(String s, int start) {
		int[] res = new int[2];
		res[0] = 0;
		res[1] = 0;

		int begin = start;
		while (begin < s.length() && s.charAt(begin) != '(') {
			begin++;
		}
		if (begin < s.length()) {
			int bracket = 1;
			res[0] = begin;
			int end = begin + 1;
			while (bracket != 0) {
				if (s.charAt(end) == ')')
					bracket--;
				else if (s.charAt(end) == '(') {
					bracket++;
				}
			}
			res[1] = end;
		}
		return res;

	}
}
