package leetcode;
public class Q134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = cost.length;
		int[] minus = new int[n];
		int left = 0;
		for (int i = 0; i < n; i++) {
			minus[i] = gas[i] - cost[i];
			left += minus[i];
		}
		if (left < 0)
			return -1;
		for (int i = 0; i < n; i++) {
			if (minus[i] < 0)
				continue;
			int total = 0;
			for (int j = i; j < n + i; j++) {
				total += minus[(j) % n];
				if (total < 0){
					i=j;
					break;
				}
			}
			if (total >= 0)
				return i;
		}
		return -1;
	}
}