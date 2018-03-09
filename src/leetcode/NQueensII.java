package leetcode;

import java.util.ArrayList;
import java.util.List;


public class NQueensII {
    public int totalNQueens(int n) {
        return dfs(new boolean[n],new boolean[2*n-1], new boolean[2*n-1],0, n );
    }

    private int dfs(boolean[] colCheck, boolean[] diag1Check, boolean[] diag2Check, int row, int n) {
        if (row == n) return 1;
        int result = 0;
        for (int col = 0; col < n; col++) {
            int diag1 = row + col;
            int diag2 = row - col + n - 1;
            if (colCheck[col] || diag1Check[diag1] || diag2Check[diag2]) continue;
			colCheck[col] = true;
			diag1Check[diag1] = true;
			diag2Check[diag2] = true;
            int temp = dfs(colCheck, diag1Check, diag2Check, row + 1, n);
            result +=temp;
            colCheck[col] = false;
			diag1Check[diag1] = false;
			diag2Check[diag2] =false;
        }
        return result;
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        for (int i = 1; i < 9 ; i++) {
            System.out.println( nQueensII.totalNQueens(i));
        }
    }

}