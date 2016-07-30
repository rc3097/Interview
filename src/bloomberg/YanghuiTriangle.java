package bloomberg;

import java.util.*;

public class YanghuiTriangle {

	public int get(int x, int y) {
		int[][] combination = new int[x+1][x+1];
		getCombinayion(combination);
		return combination[x][y];
	}

	private void getCombinayion(int[][] combination) {
		for (int i =0; i<combination.length; i++) {
			combination[i][0] = 1;
			combination[0][i] = 0;
		}

		for (int i =1; i<combination.length;i++) {
			for (int j=1; j<combination.length;j++) {
				combination[i][j] = combination[i-1][j-1]+combination[i-1][j];
			}
		}
	}
	
	public static void main(String[] args) {
		YanghuiTriangle q = new YanghuiTriangle();
		System.out.println(q.get(1,0));
		System.out.println(q.get(2,0));
		System.out.println(q.get(2,1));
		System.out.println(q.get(3,1));
	}
}