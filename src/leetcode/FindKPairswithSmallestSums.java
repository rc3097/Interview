package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by runpeng.chen on 8/9/17.
 */
public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        int[] index = new int[nums1.length];

        while (res.size() < k) {
            int selectIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                if (index[i] == nums2.length) continue;
                if (nums1[i] + nums2[index[i]] < min) {
                    min = nums1[i] + nums2[index[i]];
                    selectIndex = i;
                }
            }
            if (min == Integer.MAX_VALUE) break;
            res.add(new int[]{nums1[selectIndex], nums2[index[selectIndex]]});
            index[selectIndex]++;
        }

        return res;
    }

    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(0, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for (int i =0; i< nums2.length && i<k; i++) {

        }
        return null;

    }

}
