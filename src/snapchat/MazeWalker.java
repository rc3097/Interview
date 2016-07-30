package snapchat;
import java.util.*;

public class MazeWalker{
	public boolean isWalkable(int[][] maze) {
		int[] start = new int[2];
		for (int i =0; i< maze.length;i++) 
			for (int j=0; j<maze[i].length;j++)
				if (maze[i][j]==1) {
					start[0]=i;
					start[1] =j;
				}
		
		Queue<int[]> queue = new LinkedList();
		queue.add(start);
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[start[0]][start[1]] = true;
		int[] dx = new int[]{1,0,-1,0};
		int[] dy = new int[]{0,1,0,-1};

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			for (int i =0; i<4;i++) {
				int[] newpoint = new int[2];
				newpoint[0] = point[0]+dx[i];
				newpoint[1] = point[1]+dy[i];

				if (0<=newpoint[0] && newpoint[0]<maze.length && 0<=newpoint[1] && newpoint[1]<maze[0].length) {
					if (visited[newpoint[0]][newpoint[1]]==false && maze[newpoint[0]][newpoint[1]]!=5) {
						if (maze[newpoint[0]][newpoint[1]]==9) return true;
						visited[newpoint[0]][newpoint[1]] = true;
						queue.add(newpoint);
					}
				}
			}
		}
		return false;
	}
}