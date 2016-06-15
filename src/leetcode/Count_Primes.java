package leetcode;

public class Count_Primes {
    public int countPrimes(int n) {
        boolean[] notPrime=new boolean[n];
        if (n<2) return 0;
        int count=0;
        for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				count++;
				int times=(n-1)/i;
				for (int j = 1; j < times; j++) {
					notPrime[(j+1)*i]=true;
				}
			}
		}
        return count;
    }
}