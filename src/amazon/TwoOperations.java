package amazon;

import java.util.Arrays;
import java.util.HashMap;
/*
 * 第二题： Two Operations，题意是从零开始，只有两种操作可供选择，+ 1 和 × 2，求到某个数字的最小的操作次数.  
比如(从左向右计算，我就不加括号了)
       3 = 0 +1+1+1 (3) / 0 + 1 * 2 + 1(3)  
       5 = 0 + 1 * 2 * 2 + 1(4). 鍥磋鎴戜滑@1point 3 acres
上来想复杂了，还考虑用DP去做，后来发现有几个case超时。后来发现，* 2 操作一定比 + 1操作快，然后就改了下，然后就pass了test case。因为输入项里说明n <= pow(10, 16), 所以这里用Integet.parseInt(S)会报异常，所以用Long去接收。最后加了个cache优化一下
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194035&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 */
public class TwoOperations {
	public int[] MinOperations(long[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = helper(nums[i]);
		}
		return res;
	}

	HashMap<Long, Integer> map = new HashMap();

	private int helper(long num) {
		if (num==0) return 0;
		if (map.containsKey(num)) return map.get(num);
		int res;
		if (num % 2==0) {
			res = helper(num/2);
		} else {
			res = helper(num-1);
		}
		res++;
		map.put(num, res);
		return res;
	}
	
	public static void main(String[] args) {
		TwoOperations q = new TwoOperations();
		System.out.println(Arrays.toString(q.MinOperations(new long[]{0,3,5,4})));
	}
}
