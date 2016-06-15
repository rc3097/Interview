package leetcode;

public class Bitwise_AND_of_Numbers_Range {

	/**
	 * @param args
	 */
    public int rangeBitwiseAnd(int m, int n) {
		int mask=Integer.MAX_VALUE;
		while ((m & mask) != (n & mask)) mask <<= 1;
		return (mask & m);
    }
}
