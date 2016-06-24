package uber;

import java.util.HashSet;

public class ReverseWordsinaStringII {

	public void reverseWordsnotinspace(char[] s) {
		int r = s.length - 1;
		char[] res = new char[s.length];
		int len = 0;
		while (r >= 0) {
			int rend = r;
			while (0 <= r && s[r] != ' ')
				r--;
			for (int i = r + 1; i <= rend; i++)
				res[len++] = s[i];
			if (len<s.length) res[len++] = ' ';
			r--;
		}
		
		for (int i =0; i<s.length;i++) {
			s[i]=res[i];
		}
	}
	
	public void reverseWords(char[] s) {
	    reverse(s, 0, s.length-1);  // reverse the whole string first
	    int r = 0;
	    while (r < s.length) {
	        int l = r;
	        while (r < s.length && s[r] != ' ')
	            r++;
	        reverse(s, l, r-1);  // reverse words one by one
	        r++;
	    }
	}

	public void reverse(char[] s, int l, int r) {
	    while (l < r) {
	        char tmp = s[l];
	        s[l++] = s[r];
	        s[r--] = tmp;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = "the sky is blue".toCharArray();
		ReverseWordsinaStringII q = new ReverseWordsinaStringII();
		q.reverseWords(s);
		System.out.println(s);
		
		s = "".toCharArray();
		q = new ReverseWordsinaStringII();
		q.reverseWords(s);
		System.out.println(s);
		
		s = "s".toCharArray();
		q = new ReverseWordsinaStringII();
		q.reverseWords(s);
		System.out.println(s);
		
		
		
	}

}
