package amazon;
import java.util.*;
/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194035&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * 第一题： 找第一个重复出现的字符串，字符串可能由多个空格/分号/冒号/逗号/句号/减号 分隔开
 */
public class FirstRepeatedWord {
	public String getFirstRepeat(String s) {
		if (s.length()==0) return null;
		HashSet<String> set = new HashSet();
		for (String word: s.split("\\P{Alpha}+")) {
			if (set.contains(word)) {
				return word;
			} else {
				set.add(word);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		FirstRepeatedWord q = new FirstRepeatedWord();
		System.out.println(q.getFirstRepeat("He ... . .had had a ..."));
	}
}
