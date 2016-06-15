package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<String>();
		generator(results, "", n, n);
		return results;
	}

	private void generator(List<String> results, String s, int l, int r) {
		if (l>r) return;
		if (r==0) {
			results.add(s);
			return ;
		}
		
		if (l>0) {
			generator(results, s+"(", l-1, r);
		}
		if (r>l) {
			generator(results, s+")", l, r-1);
		}
		
	}
}
