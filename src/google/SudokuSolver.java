package google;

import java.util.*;
public class SudokuSolver{
 	public void solveSudoku(char[][] board) {
    	LinkedList<Integer> availList = new LinkedList();

        for (int i =0; i<9; i++) {
        	for (int j=0; j<9;j++) {
        		if (board[i][j]=='.') 
        			availList.add(i*9+j);
        	}
        }

        dfs(board, availList);
    }

    public boolean dfs(char[][] board, LinkedList<Integer> availList) {
    	if (availList.isEmpty()) return true;
    	int temp = availList.pollFirst();
    	int x = temp / 9;
    	int y = temp % 9;
    	for (char c='1'; c<='9';c++) {
    		board[x][y] = c;
    		if (checkMove(board, x, y)) {
    			if (dfs(board, availList)) {
    				return true;
    			}
    		}
    	}
    	board[x][y] = '.';
    	availList.addFirst(temp);
    	return false;
    }

    private boolean checkMove(char[][] board, int row, int col) {
    	HashSet<Character>  sets = new HashSet();
    	// row
    	for (int i = 0; i<9; i++) {
    		if (board[row][i]=='.') continue;
    		if (sets.contains(board[row][i])) return false;
    		sets.add(board[row][i]);
    	}

    	// col
    	sets.clear();
    	for (int i =0; i<9; i++) {
    		if (board[i][col]=='.') continue;
    		if (sets.contains(board[i][col])) return false;
    		sets.add(board[i][col]);
    	}

    	int s_x = row/3*3;
    	int s_y = col/3*3;
    	sets.clear();
    	for (int i=0; i<3;i++) {
    		for (int j=0; j<3;j++) {
    			if (board[i+s_x][j+s_y]=='.') continue;
    			if (sets.contains(board[i+s_x][j+s_y])) return false;
    			sets.add(board[i+s_x][j+s_y]);
    		}
    	}
    	return true;
    }
}