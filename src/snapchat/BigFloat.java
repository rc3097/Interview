package snapchat;
import java.util.*;
/*
* Big Float add
*/

public class BigFloat {
	public String add(String a, String b) {
		int apoint = a.length()-1;
		int adecimal = 0;
		while (a.charAt(apoint)!='.') {
			apoint--;
			adecimal++;
		}
		int bpoint = b.length()-1;
		int bdecimal = 0;
		while (b.charAt(bpoint)!='.') {
			bpoint--;
			bdecimal++;
		}

		if (adecimal<bdecimal) {
			for (int i=0; i<bdecimal-adecimal;i++) a=a+"0";
		} else {
			for (int i=0;i<bdecimal-adecimal;i++) b=b+"0";
		}
		
		
		int point = Math.max(adecimal, bdecimal);
		int[] anum = str2num(a);
		int[] bnum = str2num(b);
		int[] res = new int[Math.max(anum.length,bnum.length)+1];

		for (int i =0; i< res.length;i++) 
			res[i] =  ((i<anum.length)?anum[i]:0) + ((i<bnum.length)? bnum[i]:0);
		

		for (int i=0; i< res.length-1; i++) {
			res[i+1] += res[i]/10;
			res[i] = res[i] % 10;
		}

		int len = res.length;
		while (len>point+1 && res[len-1]==0) len--;
		String sres = "";
		for (int i =0; i< len;i++) {
			if (i==point) {
				sres= "."+sres;
			}
			sres = res[i]+sres;

		}
		return sres;
	}

	private int[] str2num(String a) {
		int[] num =  new int[a.length()];
		int idx= 0;
		for (int i = a.length()-1; i>=0;i--) {
			if (a.charAt(i)=='.' || a.charAt(i)=='-') continue;
			num[idx++] =  a.charAt(i)-'0';
		}
		return num;
	}

	private int move(String a, String b) {
		int apoint = a.length()-1;
		int adecimal = 0;
		while (a.charAt(apoint)!='.') {
			apoint--;
			adecimal++;
		}
		int bpoint = b.length()-1;
		int bdecimal = 0;
		while (b.charAt(bpoint)!='.') {
			bpoint--;
			bdecimal++;
		}

		if (adecimal<bdecimal) {
			for (int i=0; i<bdecimal-adecimal;i++) a=a+"0";
		} else {
			for (int i=0;i<bdecimal-adecimal;i++) b=b+"0";
		}

		return Math.max(adecimal, bdecimal);
	}

	public static void main(String[] args) {
		BigFloat q = new BigFloat();
		System.out.println(q.add("1.0","1.02")); //2.02
		System.out.println(q.add("0.0","0.0")); // 0.0
		System.out.println(q.add("0.0","0.1")); // 0.1
		System.out.println(q.add("0.1","0.9")); //1.0
		
		System.out.println(q.add("1.10","9.91")); // 11.01
	}
}