package facebook;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192763&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length()==0) return 0;
        int[] dp = new int[s.length()]; 
        dp[0] = s.charAt(0)=='0'?0:1;
        for (int i=1; i<s.length();i++) {
            dp[i]= s.charAt(i)=='0'?0:dp[i-1];
            int twodigits =  Integer.valueOf(s.substring(i-1,i+1));
            if (twodigits<=26 && 10<=twodigits) {
                dp[i]+=(i-2>=0)?dp[i-2]:1;
            }
        }
        return dp[s.length()-1];
    }
}
