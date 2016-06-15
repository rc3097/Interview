package leetcode;

public class myPow {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;
        if (n>0) {
        	double temp=myPow(x, n/2);
        	return temp*temp*myPow(x, n % 2);
        } else {
        	double temp=myPow(x, (-n)/2);
        	return 1.0/(temp*temp*myPow(x, (-n) % 2));
		}
    }
}