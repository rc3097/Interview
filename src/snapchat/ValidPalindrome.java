package snapchat;
import java.util.*;
/*
*   Valid Palindrome.
    Follow-up鏄彲浠ュ鍒犳敼锛屼娇寰楄緭鍏ュ瓧绗︿覆鎴愪负palindrome锛岃緭鍑烘渶灏戞搷浣滄鏁般�傦紙DP锛�
    搴旇鏄痜ollowup娌℃潵寰楀強鍐欏畬锛屽彧鏄彁渚涗簡鎬濊矾
*/

public class ValidPalindrome{
	HashMap<String, Integer> map = new HashMap();
	public int minimumChange(String s) {
		if (map.containsKey(s)) return map.get(s);
		if (s.length()==0 || s.length()==1) return 0;
		int res=Integer.MAX_VALUE;
		if (s.charAt(0)==s.charAt(s.length()-1)) {
			res = minimumChange(s.substring(1,s.length()-1));
		} else {
			int changechr = minimumChange(s.substring(1,s.length()-1))+1;
			int leftinsert = minimumChange(s.substring(0,s.length()-1)) +1 ;
			int rightinsert = minimumChange(s.substring(1))+1;
		    res = Math.min(changechr,leftinsert);
			res = Math.min(rightinsert, res);
		}

		map.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		ValidPalindrome q = new ValidPalindrome();
		System.out.println(q.minimumChange("abaa"));
		System.out.println(q.minimumChange("aba"));
	}
}