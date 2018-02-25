package leetcode;

import java.util.Arrays;

/**
 * Created by runpeng.chen on 5/19/17.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] charcount = new int[26];
        for (char ch : s1.toCharArray()) {
            charcount[ch - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            charcount[ch - 'a']--;
            if (i + 1 > s1.length()) charcount[s2.charAt(i - s1.length()) - 'a']++;
            if (i + 1 >= s1.length()) {
                if (isEmpty(charcount)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmpty(int[] charcount) {
        for (int i : charcount) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("cabc", "cabc"));
        System.out.println(new PermutationInString().checkInclusion("ccab", "cab"));
        System.out.println(new PermutationInString().checkInclusion("cab", "abc"));
    }
}