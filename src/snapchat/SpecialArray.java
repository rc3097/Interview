package snapchat;
import java.util.*;

/*
第一提，给你你个数组，要你返回数组的最小值的平方是否小于最大值。题目很简单，需要注意的就是最小值的平方可能越界。
佛罗阿噗：如果这个数组不满足第一题中的条件，然后允许你执行“删除数组的第一个元素”的操作，让你返回要执行多少次，也就是删除多少个数组前面的元素后才能满足第一题中的条件。如果删完都不满足，返回-1；这一题小哥反复提示才想出来一个O（n）的做法，然后今天看还有个小bug，哎。。
接着佛罗阿噗：如果可以每次都可以选择删除第一个或者最后一个，问最少要删掉几次。。(dp)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189726&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D21%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
public class SpecialArray {
	//给你你个数组，要你返回数组的最小值的平方是否小于最大值
	public boolean checkMinSquare(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num:nums) min = Math.min(min,num);
		for (int num:nums) max = Math.max(max,num);
		if (max<=0) return false;
		min = Math.abs(min);
		if (max/min>min) return true;
		return false;
	}

	private boolean checkPow(int min, int max) {
		if (min*1.0>max/min*1.0) return true;
		return false;
	}
	class Node {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int val = -1;
	}
	HashMap<Integer,HashMap<Integer, Node>> mem = new HashMap();

	public Node minialter(int[] nums, int start, int end) {
		if (start>end) return new Node();
		if (mem.containsKey(start) &&  mem.get(start).containsKey(end)) {
			return mem.get(start).get(end);
		}
		Node node = new Node();
		if (start==end) {
			node.min = nums[start];
			node.max = nums[end];
			if (checkPow(nums[start], nums[end])) 
				node.val = 0;
			else 
				node.val = -1;
		} else {
			Node leftpart = minialter(nums, start+1,end);
			int min = Math.min(nums[start],leftpart.min);
			int max = Math.max(nums[start],leftpart.max);
			node.min = min;
			node.max = max;
			if (checkPow(min, max)) {
				node.val = 0;
			} else {
				if (leftpart.val!=-1) {
					node.val=leftpart.val+1;
				}
			}
			Node rightpart = minialter(nums, start, end-1);
			min =Math.min(nums[end],rightpart.min);
			max = Math.max(nums[end], rightpart.max);
			if (checkPow(min,max)) {
				node.val = 0;
			} else {
				if (rightpart.val!=-1) {
					node.val =  Math.min(rightpart.val+1,node.val);
				}
			}
		}

		if (!mem.containsKey(start)) {
			mem.put(start, new HashMap());
		}
		mem.get(start).put(end, node);
		return node;
	}
	public static void main(String[] args) {
		SpecialArray q = new SpecialArray();
		System.out.println(q.minialter(new int[]{4,3,5,9},0,3).val); //1
		System.out.println(q.minialter(new int[]{1,3,5,9},0,3).val); //2
		
		System.out.println(q.minialter(new int[]{4,4,5,9,10},0,4).val);  //0
		System.out.println(q.minialter(new int[]{1,2,2,9,4,4},0,4).val); //0
		
	}
}