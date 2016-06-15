package leetcode;

public class Googletest1 {
    public int solution(int X) {
        // write your code in Java SE 8
    	String Xstr = ""+X;
    	boolean issame = false;
    	int lastsame = 0;
    	for (int i = 0; i < Xstr.length()-1; i++) {
			if (Xstr.charAt(i)==Xstr.charAt(i+1)) {
				issame= true;
				lastsame = i;
			} else {
				if (issame) {
					issame = false;
					if (Xstr.charAt(i+1)>Xstr.charAt(i)) {
						String resultString = Xstr.substring(0, i)+Xstr.substring(i+1, Xstr.length());
						return Integer.valueOf(resultString);
					}
				}		
			}
		}
    	String result = Xstr.substring(0, lastsame)+Xstr.substring(lastsame+1, Xstr.length());
    	return Integer.valueOf(result);
    }
}