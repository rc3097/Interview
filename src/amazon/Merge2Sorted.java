package amazon;

/*
 * http://www.1point3acres.com/bbs/thread-169516-1-1.html
 * 2.merge 2 sortted array..
 */
public class Merge2Sorted {
	public int[] merge(int[] anums, int[] bnums) {
		int[] nums = new int[anums.length + bnums.length];
		int idx = 0;
		int aidx = 0;
		int bidx = 0;
		while (aidx < anums.length && bidx < bnums.length) {
			if (aidx > bidx) {
				nums[idx++] = anums[aidx++];
			} else {
				nums[idx++] = bnums[bidx++];
			}
		}
		while (aidx<anums.length) {
			nums[idx++] = anums[aidx++];
		}
		
		while (bidx<bnums.length) {
			nums[idx++] = bnums[bidx++];
		}
		
		return nums;
	}
}
