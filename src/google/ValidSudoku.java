package google;

import java.util.*;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> sets = new HashSet();
        // row
        for (int row=0; row<9; row++) {
        	sets.clear();
            for (int col=0; col<9;col++) {
                if (board[row][col]!='.') {
                	if (!sets.contains(board[row][col])) {
                		sets.add(board[row][col]);
                	} else {
                		return false;
                	}
                }
            }
        }
        // col
        for (int col=0; col<9; col++) {
        	sets.clear();
        	for (int row = 0; row<9; row++) {
        		if (board[row][col]!='.') {
        			if (!sets.contains(board[row][col])) {
        				sets.add(board[row][col]);
        			} else {
        				return false;
        			}
        		}
        	}
        }

        // 3*3

        for (int i = 0; i<9; i+=3) {
        	for (int j = 0; j<9; j+=3) {
        		sets.clear();
        		for (int row = 0; row<3 ; row++) {
        			for (int col = 0; col<3; col++) {
        				if (board[row+i][col+j]=='.') continue;
        				if (!sets.contains(board[row+i][col+j])) {
        					sets.add(board[row+i][col+j]);
        				} else {
        					return false;
        				}
        			}
        		}
        	}
        }

        return true;
    }
}
