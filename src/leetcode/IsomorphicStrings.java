package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (testS2T(s, t)) return false;
        if (testS2T(t, s)) return false;
        return true;
    }

    private boolean testS2T(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        int index = 0;
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        while (index < sCharArr.length) {
            char source = sCharArr[index];
            char target = tCharArr[index];
            if (characterMap.containsKey(source)) {
                if (characterMap.get(source) != target) return true;
            } else {
                characterMap.put(source, target);
            }
            index++;
        }
        return false;
    }
}
