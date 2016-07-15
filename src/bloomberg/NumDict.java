package bloomberg;

import java.util.*;

public class NumDict {
	public ArrayList<Integer> getNums(int n) {
		ArrayList<Integer> res = new ArrayList();
		for (int i =1; i<=9;i++) {
			generate(res, i,n);
		}
		return res;
	}

	private void generate(ArrayList<Integer> res, int cur, int n) {
		if (cur>n) return;
		res.add(cur);
		for (int i=0;i<10;i++) {
			if ((long) cur*10+i <=n) {
				generate(res,cur*10+i,n);
			}
		}
	}

	public static void main(String[] args) {
		NumDict q = new NumDict();
		System.out.println(q.getNums(121));
	}
}