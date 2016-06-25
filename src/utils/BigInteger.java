package utils;


public class BigInteger {

	private String plus(String a, String b) throws Exception {
		if (a.length() == 0 || b.length() == 0)
			throw new Exception();
		int[] anum = str2nums(a);
		int[] bnum = str2nums(b);
		int[] res = new int[Math.max(anum.length, bnum.length) + 1];

		int aidx = 0;
		int bidx = 0;
		int i = 0;
		while (aidx < anum.length || bidx < bnum.length) {
			res[i++] = (aidx < anum.length ? anum[aidx++] : 0)
					+ (bidx < bnum.length ? bnum[bidx++] : 0);
		}
		i = res.length - 1;
		while (i>0 && res[i] == 0)
			i--;
		int sign = res[i] >= 0 ? 1 : -1;
		for (i = 0; i < res.length - 1; i++) {
			if (sign > 0) {
				res[i + 1] += (res[i] / 10);
				res[i] = (res[i] + 10) % 10;
			} else {
				res[i + 1] += (res[i] > 0) ? 1 : 0;
				res[i] = Math.abs((res[i] > 0) ? res[i] - 10 : res[i]);
			}
		}

		String s = "";
		i = res.length - 1;
		while (i>0 && res[i] == 0)
			i--;

		for (int j = 0; j <= i; j++) {
			s = res[j] + s;
		}
		if (sign==-1 && s.charAt(0)!='-') s ="-"+s;
		return s;
	}

	private int[] str2nums(String s) {
		int[] nums;
		if (s.charAt(0) == '-') {
			nums = new int[s.length() - 1];
		} else {
			nums = new int[s.length()];
		}
		int i = 0;
		int idx = nums.length - 1;
		int sign = s.charAt(0) == '-' ? -1 : 1;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				nums[idx--] = (s.charAt(i) - '0') * sign;
			}
			i++;
		}
		return nums;
	}
	
	public String substract(String a, String b) throws Exception {
		if (a.charAt(0)=='-' && b.charAt(0)=='-') {
			return plus(a,b.substring(1));
		} else if (a.charAt(0)=='-') {
			return "-"+plus(a.substring(1), b);
		} else if (b.charAt(0)=='-') {
			return plus(a,b.substring(1));
		} else {
			return plus(a,"-"+b);
		}
	}

	public String multiply(String a, String b) throws Exception {
		if (a.length()==0 || b.length()==0) throw new Exception();
		int sign = 1;
		if (a.charAt(0)=='-') {
			sign*=-1;
			a = a.substring(1);
		}
		if (b.charAt(0)=='-') {
			sign*=-1;
			b = b.substring(1);
		}
		int[] anum = str2nums(a);
		int[] bnum = str2nums(b);
		int[] res = new int[anum.length+bnum.length];

		for (int i = 0 ; i< anum.length; i++) {
			for (int j =0; j<bnum.length;j++)  {
				res[i+j] += anum[i]*bnum[j];
			}
		}

		for (int i =0; i<res.length-1;i++) {
			res[i+1] +=  res[i] /10 ;
			res[i] = res[i] % 10;
		}

		int end = res.length-1;
		while (end>0 && res[end]==0) end--;
		String s = "";
		res[end] *=sign;
		for (int j = end; j>=0; j--) {
			s = s+res[j];
		}
		return s;
	}

	public String divide(String a, int b) throws Exception {
		if (a.length()==0) throw new Exception();
		if (b==0) throw new Exception();
		int sign =1;
		if (a.charAt(0)=='-') {
			a = a.substring(1);
			sign*=-1;
		} 
		if (b<0) {
			b = -b;
			sign*=-1;
		}
		int divide = 0;
		String s = "";
		for (int i = 0; i<a.length();i++) {
			divide = divide * 10 + a.charAt(i)-'0';
			s +=divide / b;
			if (divide>=b) {
				divide = divide % b; 
			}
		}
		int start = 0;
		while (start>0 && s.charAt(start)=='0') start++;
		s = s.substring(start);
		if (sign==-1 && s.charAt(0)!='0') return "-"+s;
		return s;
	}

	public static void main(String[] args) throws Exception {
		BigInteger q = new BigInteger();
		System.out.println(q.plus("0","0"));
		System.out.println(q.substract("0","0"));
		System.out.println(q.plus("-111111111", "1112")); // -111109999
		System.out.println(q.plus("111111111", "-1111")); // 111110000
		System.out.println(q.plus("111", "11111111")); // 11111222
		System.out.println(q.plus("111111111", "1111")); // 111112222
		System.out.println(q.plus("-111111111", "1111")); // -111110000
		System.out.println(q.plus("-111111111", "-1111")); // -111112222
		System.out.println(q.plus("1000", "-1111"));
		System.out.println(q.plus("0", "-1111"));
		System.out.println(q.plus("111111111", "0"));
		System.out.println(q.substract("111111111", "0"));
		System.out.println(q.substract("0","111111"));
		System.out.println(q.multiply("0","11111"));
		System.out.println(q.multiply("0","0"));
		System.out.println(q.multiply("0","-11111"));
		System.out.println(q.multiply("-19","-11111"));
		System.out.println(q.multiply("19","-11111"));
		System.out.println(q.divide("99",-9));
		System.out.println(q.divide("4",10));
		System.out.println(q.divide("4",1));
		System.out.println(q.divide("-4",1));
		System.out.println(q.divide("4",-1));
		
		
	}
}
