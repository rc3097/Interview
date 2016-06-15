package leetcode;

public class Reverse_Bits {
	 public int reverseBits(int n) {
	        StringBuffer tobitString=new StringBuffer(Integer.toBinaryString(n));
		// 	StringBuffer tobitString=new StringBuffer("11111111111111111111111111111111");
	        String reverseString=tobitString.reverse().toString();
	        for (int i = 0; i < 32-tobitString.length(); i++) {
				reverseString+="0";
			}
	        long result=Long.parseLong(reverseString, 2);
	        return (int) result;
	    }
}
