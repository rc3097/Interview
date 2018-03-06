package leetcode;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> jewelSet = new HashSet<>();
        for (char jewel : J.toCharArray()) {
            jewelSet.add(jewel);
        }

        for (char stone : S.toCharArray()) {
            if (jewelSet.contains(stone)){
                res++;
            }
        }
        return res;
    }
}
