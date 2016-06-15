package leetcode;
import java.util.ArrayList;
import java.util.List;


public class NQueensII {
	int result=0;
	public int totalNQueens(int n) {
		result=0;
		dfs( new ArrayList<String>(), 0, n);
		return result;
	}

	private void dfs( ArrayList<String> currentMap,
			int row, int n) {
		// TODO Auto-generated method stub
		if (row == n) {
			result++;
			return;
		}
		// new row
		char[] nrow = new char[n];
		for (int i = 0; i < n; i++) {
			nrow[i]='.';
		}

		for (int i = 0; i < n; i++) {
			if (checkqueens(currentMap, row, i, n)) {
				nrow[i]='Q';
				currentMap.add(String.valueOf(nrow));
				dfs(currentMap, row+1, n);
				currentMap.remove(row);
				nrow[i] ='.';
			}
		}

	}

	private boolean checkqueens(ArrayList<String> currentMap, int row,
			int column, int n) {
		// TODO Auto-generated method stub
		// up
		for (String string : currentMap) {
			if (string.charAt(column) == 'Q') {
				return false;
			}
		}

		int[] leftup = new int[] { -1, -1 };
		int[] rightup = new int[] { -1, 1 };
		int row_i = row - 1;
		int column_i = column - 1;
		while (row_i >= 0 && column_i >= 0) {
			if (currentMap.get(row_i).charAt(column_i) == 'Q') {
				return false;
			}
			row_i += leftup[0];
			column_i += leftup[1];
		}
		row_i = row - 1;
		column_i = column + 1;
		while (row_i >= 0 && column_i < n) {
			if (currentMap.get(row_i).charAt(column_i) == 'Q') {
				return false;
			}
			row_i += rightup[0];
			column_i += rightup[1];
		}

		return true;
	}
}