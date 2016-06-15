package leetcode;

public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if (num==0) return false;
        return Math.log(num) / Math.log(4)==Math.round(Math.log(num) / Math.log(4));
    }
}
