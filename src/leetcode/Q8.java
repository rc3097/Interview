package leetcode;
public class Q8 {
	public int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str.length() == 0)
			return 0;
		boolean positive = true;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			if (str.charAt(0) == '-')
				positive = false;
			str=str.substring(1);
		}
		int index=0;
		double result=0;
		while (str.length()>index && '0'<=str.charAt(index) && str.charAt(index)<='9' ) {
			result = result*10+ Integer.valueOf(str.charAt(index))-48;
			index++;
		}
		if (!positive) result*=-1;
		return (int) result;
	}
}