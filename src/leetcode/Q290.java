package leetcode;
import java.util.HashMap;

public class Q290 {
	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> word2map = new HashMap<Character, String>();
		HashMap<String, Character> map2word = new HashMap<String, Character>();
		String[] strwords = str.split(" ");
		if (strwords.length != pattern.length())
			return false;
		for (int i = 0; i < strwords.length; i++) {
			if (word2map.containsKey(pattern.charAt(i))) {
				if (!word2map.get(pattern.charAt(i)).equals(strwords[i]))
					return false;
			} else {
				word2map.put(pattern.charAt(i), strwords[i]);
			}
			if (map2word.containsKey(strwords[i])) {
				if (!map2word.get(strwords[i]).equals(pattern.charAt(i)))
					return false;
			} else {
				map2word.put(strwords[i], pattern.charAt(i));
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}
}
