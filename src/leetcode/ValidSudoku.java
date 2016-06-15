package leetcode;

public class ValidSudoku {
	   public boolean isValidSudoku(char[][] board) {
	        int[][] num = new int[board.length][10];
	        for (int i=0;i<9;i++) {
	            for (int j = 0; j<9;j++) {
	                if (board[i][j]!='.') {
	                    num[i][board[i][j]-49]++;
	                    if (num[i][board[i][j]-49]>1) return false;
	                }
	            }
	        }
	        num = new int[board.length][10];
	        for (int j=0; j<9;j++) {
	            for (int i=0;i<9;i++) {
	                if (board[i][j]!='.') {
	                    num[j][board[i][j]-49]++;
	                    if (num[j][board[i][j]-49]>1) return false;
	                }
	            }
	        }
	        
	        for (int i = 0; i<9;i+=3) {
	            for (int j=0; j<9;j+=3) {
	                num = new int[10][10];
	                for (int k=0;k<3;k++) {
	                    for (int l=0;l<3;l++) {
	                        if (board[i][j]!='.') {
	                            num[k*3+l][board[i+k][j+l]-49]++;
	                            if (num[k*3+l][board[i+k][j+l]-49]>1) return false;
	                        }
	                    }
	                }
	            }
	        }
	        return true;
	    }
	}