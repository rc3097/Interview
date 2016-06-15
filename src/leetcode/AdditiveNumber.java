package leetcode;
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int n = num.length();
		if (n < 3)
			return false;

		for (int i = 0; i < n / 2; i++) {
			String pprenum = num.substring(0, i + 1);

			for (int j = i + 1; j < 2*n/3  ; j++) {
				String prenum = num.substring(i + 1, j + 1);
				if (findAdditiveNumber(num.substring(j + 1, n),
						Long.valueOf(pprenum), Long.valueOf(prenum))) {
					return true;
				}
				if (num.charAt(i + 1) == '0') {
					break;
				}
			}
			if (num.charAt(0) == '0') {
				break;
			}
		}
		return false;
	}

	private boolean findAdditiveNumber(String num, long pprenum, long prenum) {
		int n = num.length();
		if (n == 0)
			return true;
		long target = pprenum + prenum;
		if (num.charAt(0) == '0' && target != 0)
			return false;
		int len = String.valueOf(target).length();
		if (len <= n) {
			String targetString = num.substring(0, len);
			if (Long.valueOf(targetString) == target) {
				return findAdditiveNumber(num.substring(len), prenum, target);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}