package leetcode;
import java.util.HashMap;

public class Roman_to_Integer {
	public int romanToInt(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);

		if (s == null)
			return 0;
		if (s.length() == 0)
			return 0;

		if (s.length() == 1)
			return hashMap.get(s.charAt(0));

		int begin = 0;
		int result = 0;
		for (int i = 1; i < s.length(); i++) {
			if (hashMap.get(s.charAt(i)) > hashMap.get(s.charAt(i - 1))) {
				result += hashMap.get(s.charAt(i))
						- hashMap.get(s.charAt(i - 1));
				i++;
			} else {
				result += hashMap.get(s.charAt(i - 1));
			}
		}
		int last = s.length() - 1;
		if (hashMap.get(s.charAt(last)) <= hashMap.get(s.charAt(last - 1))) {
			result += hashMap.get(s.charAt(last));
		}
		return result;
	}
}