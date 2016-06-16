package uber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import leetcode.Q10;
import sun.util.logging.resources.logging;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192016&pid=2471458&page=1&extra=page%3D1%26filter%3Dsortid%26sortid%3D311#pid2471458
 * 这题描述的不太清楚
 * log1. 
 * timestamp : num of driver
 * 1:00       5
 * 2:15       7
 * 3:00      20.

 * log2
 * 1:05     3
 * 2: 20    8
 * 3:00     5.

 * combined
 * 1:00     5
 * 1:05     8
 * 2:15   10
 * 2:20   15
 * 3:00   25
 * 
 * 如果 没有交集就不用求和
 */
public class MergeLog {

	public int[][] merge(int[][] log1, int[][] log2) {
		int ptr1 = 0;
		int ptr2 = 0;
		int preselect = 0;
		int preval = 0;
		ArrayList<int[]> reslist = new ArrayList<int[]>();
		while (ptr2 < log2.length || ptr1 < log1.length) {
			if (ptr2 >= log2.length
					|| (ptr1 < log1.length && ptr2 < log2.length && log1[ptr1][0] < log2[ptr2][0])) {
				preval = preselect == 1 ? 0 : preval;
				reslist.add(new int[] { log1[ptr1][0], preval + log1[ptr1][1] });
				preselect = 1;
				preval = log1[ptr1][1];
				ptr1++;
			} else if (ptr1 >= log1.length
					|| (ptr1 < log1.length && ptr2 < log2.length && log2[ptr2][0] < log1[ptr1][0])) {
				preval = preselect == 2 ? 0 : preval;
				reslist.add(new int[] { log2[ptr2][0], preval + log2[ptr2][1] });
				preselect = 2;
				preval = log2[ptr2][1];
				ptr2++;
			} else if (log2[ptr2][0] == log1[ptr1][0]) {
				reslist.add(new int[] { log2[ptr2][0],
						log2[ptr2][1] + log1[ptr1][1] });
				preselect = 0;
				preval = 0;
				ptr2++;
				ptr1++;
			}
		}

		int[][] res = new int[reslist.size()][2];
		for (int i = 0; i < reslist.size(); i++)
			res[i] = reslist.get(i);
		return res;
	}

	public static void main(String[] args) {
		MergeLog mergeLog = new MergeLog();
		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {
				{ 0, 5 }, { 2, 7 }, { 4, 20 } }, new int[][] { { 1, 3 },
				{ 3, 8 }, { 5, 5 } })));
		// [[0, 5], [1, 8], [2, 10], [3, 15], [4, 28], [5, 25]]

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {
				{ 0, 5 }, { 2, 7 }, { 5, 20 } }, new int[][] { { 1, 3 },
				{ 3, 8 }, { 5, 5 } })));
		// [[0, 5], [1, 8], [2, 10], [3, 15], [5, 25]]

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {
				{ 0, 5 }, { 2, 7 }, { 3, 3 }, { 5, 20 } }, new int[][] {
				{ 1, 3 }, { 4, 8 }, { 5, 5 } })));
		// [[0, 5], [1, 8], [2, 10], [3, 3], [4, 11], [5, 25]]

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {
				{ 0, 5 }, { 2, 7 }, { 5, 20 } }, new int[][] { { 1, 3 },
				{ 3, 8 }, { 5, 5 }, { 6, 8 } })));
		// [[0, 5], [1, 8], [2, 10], [3, 15], [5, 25], [6, 8]]

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {
				{ 0, 5 }, { 2, 7 }, { 5, 20 }, { 6, 6 } }, new int[][] {
				{ 1, 3 }, { 3, 8 }, { 5, 5 }, { 6, 8 } })));
		// [[0, 5], [1, 8], [2, 10], [3, 15], [5, 25], [6, 14]]

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] { {
				0, 5 } }, new int[][] {})));

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] { {
				0, 5 } }, new int[][] { { 0, 5 } })));

		System.out.println(Arrays.deepToString(mergeLog.merge(new int[][] {},
				new int[][] { { 0, 5 } })));

	}
}
