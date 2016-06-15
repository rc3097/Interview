package leetcode;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

public class Q70 {
	HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

	public int climbStairs(int n) {
		results.put(0, 1);
		results.put(1, 1);
		return getclimbStairs(n);
	}

	public int getclimbStairs(int n) {
		if (results.containsKey(n))
			return results.get(n);
		int temp = getclimbStairs(n - 1) + getclimbStairs(n - 2);
		results.put(n, temp);
		return temp;
	}
}