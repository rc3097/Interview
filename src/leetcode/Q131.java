package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Q131 {
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<List<String>>();
		if (s.length()==1) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(s);
			results.add(temp);
			return results;
		} else if (s.length()==0) {
			return results;
		}
		for (int i = 0; i < s.length(); i++) {
			String first = s.substring(0, i+1);
			if (isPalindrome(first)) {
				String last = s.substring(i + 1, s.length());
				List<List<String>> partition = partition(last);
				for (List<String> list : partition)
					list.add(0,first);
				if (last.equals("")){
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(first);
					results.add(temp);
				}
				results.addAll(0,partition);
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(partition("bb"));
	}
}
