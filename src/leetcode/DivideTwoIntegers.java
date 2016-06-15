package leetcode;
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MIN_VALUE;
		boolean isnegative = false;
		if ((divisor < 0) ^ (dividend < 0))
			isnegative = true;
		long pdivisor = (divisor < 0) ? (long)-divisor : (long)divisor;
		long pdividend = (dividend < 0) ? (long)-dividend : (long)dividend;
		int n = 0;
		while (pdividend >= pdivisor) {
			int step = 1;
			long xdivisor = pdivisor;
			while ((long) (xdivisor + xdivisor) <= pdividend) {
				step += step;
				xdivisor += xdivisor;
			}
			pdividend -= xdivisor;
			n += step;
		}
		return (isnegative) ? -n : n;
	}
}