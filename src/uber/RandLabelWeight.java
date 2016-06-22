package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * 
 *Weight Random Character，
 * 输入e.g. data = [{label: 'A', weight: 2}, {label: 'B', weight: 3}, {label: 'C', weight: 5}]，
 * 实现randLabel(data)，按权重随机输出label（'A'，'B'或'C'，'A'的可能性为20%，'B'为30%，'C'为50%）
 * 
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=187839&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 
 */
public class RandLabelWeight {
	public class Data {
		String label;
		int weight;
		public Data(String label, int weight) {
			this.label = label;
			this.weight = weight;
		}
	}

	public String randLabel(ArrayList<Data> weights) {
		int count = 0;
		int[] portion = new int[weights.size()];
		int i = 0;
		for (Data entry : weights) {
			count += entry.weight;
			portion[i++] = count;
		}
		Random r = new Random();
		return weights.get(lbinarysearch(portion, r.nextInt(count))).label;

	}

	public int lbinarysearch(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r+1;
	}
	
	public static void main(String[] args) {
		ArrayList<Data> datas = new ArrayList<RandLabelWeight.Data>();
		RandLabelWeight q = new RandLabelWeight();
		datas.add(q.new Data("A", 2));
		datas.add(q.new Data("B", 3));
		datas.add(q.new Data("C", 5));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
		System.out.println(q.randLabel(datas));
	}
}
