package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Athlete[] athletes = new Athlete[nums.length];
        for (int i = 0; i < nums.length; i++) {
            athletes[i] = new Athlete(nums[i], i);
        }
        Arrays.sort(athletes, new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                return -o1.score + o2.score;
            }
        });
        String[] res = new String[nums.length];

        for (int rank = 0; rank < nums.length; rank++) {
            if (rank == 0) {
                res[athletes[rank].id] = "Gold Medal";
            } else if (rank == 1) {
                res[athletes[rank].id] = "Silver Medal";
            } else if (rank == 2) {
                res[athletes[rank].id] = "Bronze Medal";
            } else {
                res[athletes[rank].id] = String.valueOf(rank + 1);
            }
        }
        return res;
    }

    class Athlete {
        int score;
        int id;

        public Athlete(int score, int id) {
            this.score = score;
            this.id = id;
        }
    }
}

