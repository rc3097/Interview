package leetcode;
public class Word_Search {
	public boolean exist(char[][] board, String word) {
		int len = board.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					char temp = board[i][j];
					board[i][j] = ' ';
					if (found(board, word, i, j, 1))
						return true;
					board[i][j] = temp;
				}
			}
		}
		return false;
	}

	public boolean found(char[][] board, String word, int x, int y, int num) {
		if (num == word.length())
			return true;
		int len = board.length;
		if (y - 1 >= 0) {
			int nextx = x;
			int nexty = y - 1;
			if (board[nextx][nexty] == word.charAt(num)) {
				char temp = board[nextx][nexty];
				board[nextx][nexty] = ' ';
				if (found(board, word, nextx, nexty, num + 1))
					return true;
				board[nextx][nexty] = temp;
			}
		}
		if (y + 1 < board[x].length) {
			int nextx = x;
			int nexty = y + 1;
			if (board[nextx][nexty] == word.charAt(num)) {
				char temp = board[nextx][nexty];
				board[nextx][nexty] = ' ';
				if (found(board, word, nextx, nexty, num + 1))
					return true;
				board[nextx][nexty] = temp;
			}
		}
		if (x + 1 < len) {
			int nextx = x + 1;
			int nexty = y;
			if (board[nextx][nexty] == word.charAt(num)) {
				char temp = board[nextx][nexty];
				board[nextx][nexty] = ' ';
				if (found(board, word, nextx, nexty, num + 1))
					return true;
				board[nextx][nexty] = temp;
			}
		}
		if (x - 1 >= 0) {
			int nextx = x - 1;
			int nexty = y;
			if (board[nextx][nexty] == word.charAt(num)) {
				char temp = board[nextx][nexty];
				board[nextx][nexty] = ' ';
				if (found(board, word, nextx, nexty, num + 1))
					return true;
				board[nextx][nexty] = temp;
			}
		}
		return false;
	}
}