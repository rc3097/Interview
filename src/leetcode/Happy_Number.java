package leetcode;
import java.util.HashSet;

public class Happy_Number {
	public boolean isHappy(int n) {

		HashSet<Integer> history = new HashSet<Integer>();
		while (n != 1 && !history.contains(n)) {
			history.add(n);
			String num = String.valueOf(n);
			int temp = 0;
			int st2num = 0;
			for (int i = 0; i < num.length(); i++) {
				st2num = Integer.valueOf(num.charAt(i)+"");
				temp += st2num * st2num;
			}
			n = temp;
		}
		if (n == 1)
			return true;
		return false;
	}
}