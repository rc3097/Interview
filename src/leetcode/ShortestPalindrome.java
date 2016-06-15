package leetcode;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length()==0) return s;
        int[] next = new int[s.length()];
        String s_rev = new StringBuilder(s).reverse().toString();
        int i = 0;
        if (s.charAt(0)==s_rev.charAt(0)) next[0]=1;
        while (i+1<s.length()) {
            if (s.charAt(next[i])==s_rev.charAt(i+1)) {
                next[i+1]=next[i]+1;
            } else {
                int j=next[i]-1;
                int idx = i+1;
                for (;j>=0;j--) {
                    if (s.charAt(j)!=s_rev.charAt(idx))
                        break;
                    idx--;
                }
                if (j==-1) {
                    next[i+1]=next[i];
                } else {
                    next[i+1]=(s_rev.charAt(i+1)==s.charAt(0))?1:0;
                }
            }
            i++;
        }

        String sb = new StringBuilder(s.substring(next[s.length()-1])).reverse().toString(); 
        return sb+s;
    }
}