package leetcode;

public class Q130 {
    private char[][] board;
    public void solve(char[][] board) {
        if (board.length==0) return;
        this.board = board;
        //left and right
        for (int i=0; i<board.length;i++) {
            dfs(i,0);
            dfs(i,board[0].length-1);
        }
        
        //up and bottom
        for (int i =0;i<board[0].length;i++) {
            dfs(0,i);
            dfs(board.length-1,i);
        }
        
        for (int i=0;i<board.length;i++) {
            for (int j=0; j<board[0].length;j++) {
                if (board[i][j]=='$') {
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }
    }
    
    private void dfs(int x, int y) {
        if (board[x][y]=='O') {
            board[x][y]='$';
            if (x-1>=0) {
                dfs(x-1,y);
            }
            if (x+1<board.length) {
                dfs(x+1,y);
            }
            if (y-1>=0) {
                dfs(x,y-1);
            }
            if (y+1<board[0].length) {
                dfs(x,y+1);
            }
        }
    }
}