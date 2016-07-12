package bloomberg;

import java.util.LinkedList;
import java.util.Queue;
/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192185&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * B��ò���ʼ�����ʸ������ϵ�project��Ȼ���ʼ���������java��pyhton���⣬thread��ʲô��
Ȼ��Ϳ�ʼд�㷨�ˣ�.

0 1 2 3 4 
0 3 0 1 7. 1point 3acres 论坛
0 3 0 1 7
0 3 3 1 7

���start�ڡ�2, 1���㣬��ô����target����3�� ��ô����������reach��3���ɵ�ͼ�εı����� ����������Ƿ���10.
 */
public class GetAreaLength {
	public int getLength(int[][] matrix, int posx, int posy) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		if (!(posx < n && posy < m && posx >= 0 && posy >= 0))
			return 0;
		Queue<Integer> queue = new LinkedList();
		boolean[][] visited = new boolean[n][m];
		queue.add(posx * n + posy);
		int target = matrix[posx][posy];
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		int res = 0;
		
		while (!queue.isEmpty()) {
			int x = queue.peek() / n;
			int y = queue.poll() % n;
			visited[posx][posy] = true;
			for (int i = 0; i < 4; i++) {
				int newx = x + dx[i];
				int newy = y + dy[i];
				if (newx >= 0 && newx < n && newy >= 0 && newy < m
						&& matrix[newx][newy] == target) {
					if (!visited[newx][newy]) {
						queue.add(newx * n + newy);
						visited[newx][newy] = true;
					}
				} else {
					res++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		GetAreaLength q = new GetAreaLength();
		System.out.println(q
				.getLength(new int[][] { { 0, 1, 2, 3, 4 }, { 0, 3, 0, 1, 7 },
						{ 0, 3, 0, 1, 7 }, { 0, 3, 3, 1, 7 } }, 1, 1));

	}
}