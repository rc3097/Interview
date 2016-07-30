package snapchat;
import java.util.*;

public class AmicableNumber {
	public List<List<Integer>> amicable(int n) {
		int[] sums = new int[n+1];
		sums[1] = 1;
		for (int i =1; i<=n/2;i++) {
			for (int j=2*i; j<=n;j+=i) 
				sums[j] += i;
		}

		HashMap<Integer,Integer> map = new HashMap();
		List<List<Integer>> res= new ArrayList();
		for (int i=1; i<=n;i++) {
			if (map.containsKey(sums[i])) {
				ArrayList<Integer> temp = new ArrayList();
				temp.add(i);
				temp.add(sums[i]);
				res.add(temp);
			} else {
				map.put(i, sums[i]);
			}
		}
		return res;

	}
}