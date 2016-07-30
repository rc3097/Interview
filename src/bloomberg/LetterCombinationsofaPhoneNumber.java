package bloomberg;

import java.util.*;
/*
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197721&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		char[][] lib = new char[][]{{'a','b','c'},{'d','e','f'},
		{'g','h','i'},{'j','k','l'},
		{'m','n','o'},{'p','q','r','s'},
		{'t','u','v'},{'w','x','y','z'}};
		List<String> res = new ArrayList();
		generate(res, lib, digits, "");
		return res;
	}


	private void generate(List<String> res, char[][] lib, String digits, String current) {
		if (digits.length()==0) {
			res.add(current);
			return ;
		}
		int digit = digits.charAt(0)-'2';
		for (char chr: lib[digit]) 
			generate(res, lib, digits.substring(1),current+chr);
	}
}