package leetcode;

import java.util.HashSet;

/**
 * Created by runpeng.chen on 5/19/17.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> distinctSet = new HashSet<>();
        for (int candy : candies) {
            distinctSet.add(candy);
        }
        return Math.min(candies.length / 2, distinctSet.size());
    }
}
