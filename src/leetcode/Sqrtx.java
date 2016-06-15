package leetcode;

public class Sqrtx {
    public int mySqrt(int x) {
    	int l = x;
    	int r = 0;
        while (l-r>1) {
			int mid = (l+r)/2;
			if (mid*mid>x)
				l=mid;
			else
				r=mid;			
		}
        return (l*l==x)?l:r;
    }
    
    public double mySqrt(double d, int p) {
    	double g =1;
    	double e =  Math.pow(0.1, p+1);
    	while (Math.abs(g-d/g)>e) {
    		g = (g+d/g)/2;
    	}
    	return g;
    }
}