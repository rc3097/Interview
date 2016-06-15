package leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replace(",","");
        s = s.replace(" ","");
        s =s.toLowerCase();
        char[] wordchar = s.toCharArray();
        int start= 0;
        int end = s.length()-1;
        while (start<end) {
            if (wordchar[start]!=wordchar[end]) {
                return false;
            } 
            start++;
            end--;
        }
        return true;
    }
}