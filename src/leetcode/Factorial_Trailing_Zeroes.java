package leetcode;

public class Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int fivenum = 0;
        int base = 1;
        while (base<=n) {
        	base *=5;
        	fivenum += n/base;
        }
        return fivenum;
    }
}