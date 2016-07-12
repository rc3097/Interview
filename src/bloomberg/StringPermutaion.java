package bloomberg;

import java.util.ArrayList;
import java.util.List;

public class StringPermutaion {
	public List<String> getSubStringPermutaion(String str) {
		String res;
		ArrayList<String> reslist = new ArrayList();
		char[] wchar = str.toCharArray();
		for (int i = 0; i < wchar.length; i++) {
			res = "";
			for (int j = i; j < wchar.length; j++) {
				res += wchar[j];
				reslist.add(res);
			}
		}
		return reslist;
	}

	public List<String> getAllPermutation(String str) {
		List<String> res = getAllPermutation(str,0);
		return res;
	}

	public List<String> getAllPermutation(String str, int idx) {
		List<String> res = new ArrayList();
		if (idx>=str.length()) {
			res.add("");
			return res;
		}

		List<String> preres =  getAllPermutation(str, idx+1);
		List<String> temp = new ArrayList();
		for (String s: preres) {
			temp.add(str.charAt(idx)+s);
		}
		res.addAll(preres);
		res.addAll(temp);
		return res;
	}

	public static void main(String[] args) {
		StringPermutaion q = new StringPermutaion();
		System.out.println(q.getSubStringPermutaion("abc"));
		System.out.println(q.getAllPermutation("abc"));
	}
}
