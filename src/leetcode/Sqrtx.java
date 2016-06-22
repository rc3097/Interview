package leetcode;

public class Sqrtx {
	public int mySqrt(int x) {
		int l = x;
		int r = 0;
		while (l - r > 1) {
			int mid = (l + r) / 2;
			if (mid * mid > x)
				l = mid;
			else
				r = mid;
		}
		return (l * l == x) ? l : r;
	}

	public double mySqrt2(double x, int p) {
		double l = (x<1)?1:x;
		double e = Math.pow(0.1, p);
		double r = 0;
			while (l - r > e) {
				double mid = (l + r) / 2;
				if (mid * mid == x)
					return mid;
				if (mid * mid > x)
					l = mid - e;
				else
					r = mid + e;
			}

		
		return l;

	}

	public double mySqrt(double d, int p) {
		double g = 1;
		double e = Math.pow(0.1, p + 1);
		while (Math.abs(g - d / g) > e) {
			g = (g + d / g) / 2;
		}
		return g;
	}

	public static void main(String[] args) {
		Sqrtx q = new Sqrtx();
		System.out.println(q.mySqrt2(1, 2));
		System.out.println(q.mySqrt2(4, 2));
		System.out.println(q.mySqrt2(0.01, 4));
	}
}