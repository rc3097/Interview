package snapchat;

import java.util.*;

public class GroupFriend {
	public ArrayList<ArrayList<Integer>> makeGroups(int[][] matrix) {
		ArrayList<ArrayList<Integer>> reslist = new ArrayList();
		for (int i=0; i<matrix.length;i++) {
			ArrayList<Integer> res = new ArrayList();
			dfs(res,matrix,i);
			reslist.add(res);
		}
		return reslist;
	}

	private void dfs(ArrayList<Integer> res, int[][] matrix, int prev) {
		res.add(prev);
		for (int next=0; next<matrix[prev].length; next++) {
			if (matrix[prev][next]==1) {
				matrix[prev][next]=0;
				dfs(res,matrix,prev);
			}
		}
	}
}