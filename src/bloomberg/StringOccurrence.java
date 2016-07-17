package bloomberg;
/*
*绗竴棰樻槸涓や釜string, str1 鍜宻tr2銆傛壘鍑轰换鎰忎竴涓猻tr2涓殑瀛楃鍦╯tr1涓涓�娆″嚭鐜扮殑浣嶇疆銆傛垜鐢ㄤ簡涓�涓猦ashset,闈㈣瘯瀹樿拷闂簡
* http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192761&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
import java.util.*;
public class StringOccurrence {
	HashMap<Character, Integer> chrMap = new HashMap();

	public StringOccurrence(String str1) {
		for (int i =0; i< str1.length(); i++) {
			if (!chrMap.containsKey(str1.charAt(i))) {
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