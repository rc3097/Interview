package uber;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 电面：在线code，一个小时。一个2d grid，由0和1组成。从某一个1开始，计算由相邻的1构成的区域的面积。
 比如：. 
 00100
 01101
 00100
 11110
 从第2行第3列的那个1开始计算，最后结果应该是8。也就是左边那些互相连接起来的1构成的面积。
 我用BFS算的。似乎也可以用UF。
 Follow up：接上题，将每一个grid看成边长为1的正方形，计算上述区域的周长。
 其实在上一题的BFS算法基础上略作修改即可。

 */
public class GridArea {
	public int getArea(char[][] grid, int x, int y) {
		if (grid.length==0 || grid[0].length==0 || grid[x][y]!='1') return 0; 
		int sum =0;
		int n = grid.length;
		int m = grid[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][m];
		queue.add(xy2num(x,y,m));
		visited[x][y] = true;
		int[] dx = new int[]{1,0,-1,0};
		int[] dy = new int[]{0,1,0,-1};

		while (!queue.isEmpty()) {
			int head = queue.poll();
			int i = head / m;
			int j = head % m;
			sum++;
			for (int k=0; k<4;k++) {
				int newx = i+dx[k];
				int newy = j+dy[k];
				if (0<=newx && newx<n && 0<=newy && newy<m && !visited[newx][newy] && grid[newx][newy]=='1') {
					visited[newx][newy] = true;
					queue.add(xy2num(newx,newy,m));
				}
			}
		}
		return sum;
	}

	public int getLength(char[][] grid, int x, int y) {
		if (grid.length==0 || grid[0].length==0 || grid[x][y]!='1') return 0; 
		int sum =1;
		int n = grid.length;
		int m = grid[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][m];
		queue.add(xy2num(x,y,m));
		visited[x][y] = true;
		int[] dx = new int[]{1,0,-1,0};
		int[] dy = new int[]{0,1,0,-1};

		while (!queue.isEmpty()) {
			int head = queue.poll();
			int i = head / m;
			int j = head % m;
			sum+=3;
			for (int k=0; k<4;k++) {
				int newx = i+dx[k];
				int newy = j+dy[k];
				if (0<=newx && newx<n && 0<=newy && newy<m && !visited[newx][newy] && grid[newx][newy]=='1') {
					visited[newx][newy] = true;
					sum--;
					queue.add(xy2num(newx,newy,m));
				}
			}
		}
		return sum;
	}
	
	private int xy2num(int x, int y, int m) {
		return x*m+y;
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[][]{
			{'0','0','1','0','0'},
			{'0','1','1','0','1'},
			{'0','0','1','0','0'},
			{'1','1','1','1','0'}};
		GridArea q= new GridArea();
		System.out.println(q.getArea(grid,1,2));
		System.out.println(q.getLength(grid,1,2));
	}
}
