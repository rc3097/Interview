package leetcode;
import java.util.ArrayList;
import java.util.HashSet;

public class Number_of_Islands {
	public int numIslands(char[][] grid) {
		int total = 0;
		if (grid == null || grid.length<1)
			return 0;
		int height = grid.length;
		int width = grid[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ("1".equals(grid[i][j] + "")) {
					int begin = 0;
					int end = 0;
					ArrayList<Integer> queue = new ArrayList<Integer>();
					HashSet<Integer> expanded = new HashSet<Integer>();
					expanded.add(i * width + j);
					queue.add(i * width + j);
					while (begin >= end) {
						int x = queue.get(end) / width;
						int y = queue.get(end) % width;
						if (!expanded.contains(x * height + y - 1)) {
							if (y - 1 >= 0 && "1".equals(grid[x][y - 1] + "")) {
								begin++;
								expanded.add(x * width + y - 1);
								queue.add(x * width + y - 1);
							}
						}
						if (!expanded.contains(x * width + y + 1)) {
							if (y + 1 < width
									&& "1".equals(grid[x][y + 1] + "")) {
								begin++;
								expanded.add(x * width + y + 1);
								queue.add(x * width + y + 1);
							}
						}
						if (!expanded.contains((x + 1) * width + y)) {
							if (x + 1 < height
									&& "1".equals(grid[x + 1][y] + "")) {
								begin++;
								expanded.add((x + 1) * width + y);
								queue.add((x + 1) * width + y);
							}
						}
						
						if (!expanded.contains((x - 1) * width + y)) {
							if (x - 1 >=0
									&& "1".equals(grid[x - 1][y] + "")) {
								begin++;
								expanded.add((x - 1) * width + y);
								queue.add((x - 1) * width + y);
							}
						}

						end++;
					}
					for (int k = 0; k < queue.size(); k++) {
						int x = queue.get(k) / width;
						int y = queue.get(k) % width;
						grid[x][y] = "0".charAt(0);
					}
					total++;
				}
			}
		}
		return total;
	}
}
