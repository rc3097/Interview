package leetcode;

public class Googledemo {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	int n = A.length;
    	if (n==0) {
    		return 0;
    	}
    	int sum[]= new int[n];
    	int sums=0;
    	for (int i = 0; i < sum.length; i++) {
    		sums+=A[i];
    		sum[i] = sums;		
		}
    	
    	if (sums == 0) return 0;
    	for (int i = 0; i < sum.length-1; i++) {
			if (sums-sum[i]==sum[i+1]) {
				return i+1;
			}
		}
    	return -1;
    }
}
