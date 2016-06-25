package booking;

/*
*1. 给一些输入 比如 {4 4 4 4，6 5 6 5，1  2 3 4，1 1 1 1， 2 3 4 8}  每一项代表一个图形4个边的长度。 然后图形可能是正方形， 矩形，或者其他。 输出有几个正方形，矩形和其他。 比如我前面那个例子就输出 2 个正方形（因为4 4 4 4 和 1 1 1 1）， 1个矩形(6 5 6 5)，2个其他(1 2 3 4 和2 3 4 8)。
* http://www.1point3acres.com/bbs/thread-144112-1-1.html
*/
public class FindShape {
	public int[] countShape(int[][] shapes) {
		int square = 0;
		int rect = 0;
		int others = 0;
		for (int[] shape: shapes) {
			if (shape.length!=4) others++;
			else if (shape[0] == shape[1] && shape[1] == shape[2] && shape[2]==shape[3])  square++;
			else if (shape[0] == shape[2] && shape[1] == shape[3]) rect++;
			else others++;
		}

		int[] res= new int[3];
		res[0] =square;
		res[1] = rect;
		res[2] = others;
		return res;
	}
}
