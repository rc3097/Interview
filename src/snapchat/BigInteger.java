package snapchat;
import java.util.*;

public class BigInteger {
	public String minus(String a, String b) {
		int[] res = new int[Math.max(a.length(),b.length())+1];
		int[] anum = str2num(a);
		int[] bnum = str2num(b);
		int idx = 0;
		for (int i=0,j=0; i<anum.length || j<bnum.length;i++,j++) {
			res[idx++]+= ((i<anum.length)?anum[i]:0)-((j<bnum.length)?bnum[j]:0);
		}
		idx= res.length-1;
		while (idx>0 && res[idx]==0) idx--;

		int sign = res[idx]>0?1:-1;
		for (int i =0; i<=idx;i++) {
			if (sign==1) {
				res[i+1] += (res[i]>=0)?res[i] /10: (res[i]+1)/10-1;
				res[i] = (res[i]+10) % 10;
			} else {
				res[i+1] += (res[i]<=0)?res[i]/10:(res[i]-1)/10+1;
				res[i] = Math.abs(res[i]-10) % 10;
			}
		}

		int len = res.length;
		while (len>1 && res[len-1]==0) len--;
		String sres = "";
		for (int i=0; i<len;i++) sres=res[i]+sres;
		if (sign==-1 && !sres.equals("0")) sres="-"+sres;
		return sres;
	}

	private int[] str2num(String a) {
		int sign = a.charAt(0)=='-'?-1:1;
		int[] res = new int[sign==-1?a.length()-1: a.length()];
		int idx = 0;
		for (int i=a.length()-1; i>=0;i--) {
			if (a.charAt(i)=='-') continue;
			res[idx++] = (a.charAt(i)-'0')*sign;
		}
		return res;
	}
	
	public static void main(String[] args) {
		BigInteger q = new BigInteger();
		System.out.println(q.minus("-300", "-3000")); //2700
		System.out.println(q.minus("-300", "3000")); //-3300
		System.out.println(q.minus("300", "3000")); // -2700
		
		System.out.println(q.minus("300", "-3000")); //3300
	}

}