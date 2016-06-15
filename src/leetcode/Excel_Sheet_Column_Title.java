package leetcode;
public class Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
		String result = "";
		while (n != 0) {
			int temp = n % 26;
			if (temp == 0) {
				temp = 26;
				n = n / 26 - 1;
				result = Character.toString((char) (64 + temp)) + result;
			} else {
				result = Character.toString((char) (64 + temp)) + result;
				n = n / 26;
			}
		}
		return result;
	}
}