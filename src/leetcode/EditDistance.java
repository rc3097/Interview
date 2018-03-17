package leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) return Math.abs(word1.length() - word2.length());
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int up = i - 1 >= 0 ? dp[i - 1][j] :j;
                int left = j - 1 >= 0 ? dp[i][j - 1] : i;
                int diag = i - 1 < 0 ?  j: (j-1<0? i: dp[i-1][j-1]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (diag <= up && diag <= left) dp[i][j] = diag;
                    else dp[i][j] = Math.min(up, left) + 1;
                } else {
                    dp[i][j] = Math.min(up, Math.min(left, diag));
                    dp[i][j]++;
                }
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println( editDistance.minDistance("sea","eat")); //2
        System.out.println( editDistance.minDistance("zoologicoarchaeologist","zoogeologist")); //10
        System.out.println( editDistance.minDistance("a","ab")); //1
        System.out.println( editDistance.minDistance("ba","ab")); //2
    }
}
