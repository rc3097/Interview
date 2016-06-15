package leetcode;
import java.util.HashMap;

public class Q246 {
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> stroboMap = new HashMap<Character, Character>();
		stroboMap.put('8', '8');
		stroboMap.put('6', '9');
		stroboMap.put('1', '1');
		stroboMap.put('9', '6');
		stroboMap.put('0', '0');
		char[] numarr = num.toCharArray();
		int head = 0;
		int tail = num.length()-1;
		while (head<=tail) {
			if (stroboMap.get(numarr[head])!=stroboMap.get(numarr[tail])) {
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}
}
