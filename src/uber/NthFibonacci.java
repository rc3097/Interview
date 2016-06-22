package uber;

/*
 * O(1)限制下找出fibonacci数列第n个数
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191754&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class NthFibonacci {
	public int getNthRecurrsion(int n) {
		if (n == 1 || n == 2)
			return 1;
		return getNthRecurrsion(n - 1) + getNthRecurrsion(n - 2);
	}

	public int getNthIteration(int n) {
		if (n == 1 || n == 2)
			return 1;
		int pre = 1;
		int p_pre = 0;
		int curr = 0;
		for (int i = 1; i < n; i++) {
			curr = p_pre + pre;
			p_pre = pre;
			pre = curr;
		}
		return curr;
	}
	
	public static void main(String[] args) {
		NthFibonacci q = new NthFibonacci();
		System.out.println(q.getNthIteration(3));
		System.out.println(q.getNthRecurrsion(3));
		System.out.println(q.getNthIteration(10));
		System.out.println(q.getNthRecurrsion(10));
	}
}
