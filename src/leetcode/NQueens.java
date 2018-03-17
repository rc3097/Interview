package leetcode;


import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        dfs(new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new ArrayList<>(), result, 0, n);
        return result;
    }

    private void dfs(boolean[] colCheck, boolean[] diag1Check, boolean[] diag2Check, List<String> currentMap, List<List<String>> result, int row, int n) {
        if (row == n) {
            result.add(new ArrayList<>(currentMap));
            return;
        }
        for (int col = 0; col < n; col++) {
            int diag1 = row + col;
            int diag2 = row - col + n - 1;
            if (colCheck[col] || diag1Check[diag1] || diag2Check[diag2]) continue;
            colCheck[col] = true;
            diag1Check[diag1] = true;
            diag2Check[diag2] = true;
            currentMap.add(generateRow(col, n));
            dfs(colCheck, diag1Check, diag2Check, currentMap, result, row + 1, n);
            currentMap.remove(currentMap.size() - 1);
            colCheck[col] = false;
            diag1Check[diag1] = false;
            diag2Check[diag2] = false;
        }
    }

    private String generateRow(int col, int n) {
        String row = "";
        for (int i = 0; i < n; i++) {
            row += i == col ? "Q" : ".";
        }
        return row;
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println( nQueens.solveNQueens(1).size());
        System.out.println( nQueens.solveNQueens(2).size());
        System.out.println( nQueens.solveNQueens(3).size());
        System.out.println( nQueens.solveNQueens(4).size());
        System.out.println( nQueens.solveNQueens(5).size());
        System.out.println( nQueens.solveNQueens(6).size());
        System.out.println( nQueens.solveNQueens(7).size());
        System.out.println( nQueens.solveNQueens(8).size());

    }
}