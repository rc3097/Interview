package bloomberg;
/*
*第一题是两个string, str1 和str2。找出任意一个str2中的字符在str1中第一次出现的位置。我用了一个hashset,面试官追问了
* http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192761&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/

public class StringOccurrence {
	HashMap<Character, Integer> chrMap = new HashMap();

	public StringOccurrence(String str1) {
		for (int i =0; i< str1.length(); i++) {
			if (!chrMap.containsKey(str1.charAt(i)) {
				chrMap.put(str1.charAt(i),i);
			}
		}
	}

	public int getFirstOccurrence(String str2, int i) {
		if (chrMap.containsKey(str2.charAt(i))) {
			return chrMap.get(str2.charAt(i));
		}
		return -1;
	}
}