package leetcode;
public class Integer_to_Roman {
	// V(5) X(10) --> I
	// L(50) C(100) --> X
	// D(500) M(1000) --> C
	public String intToRoman(int num) {
		String a[][] = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } };
		String numString = String.valueOf(num);
		String result = "";
		for (int i = numString.length() - 1; i >= 0; i--) {
			result = a[numString.length()-1-i][Integer.valueOf(numString.charAt(i)+"")] + result;
		}
		return result;
	}
}