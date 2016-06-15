package leetcode;

public class Number_of_1_Bits {
    public int hammingWeight(int n) {
    	String binaryString=Integer.toBinaryString(n);
    	int num=0;
    	for (int i = 0; i < binaryString.length(); i++) {
			if ("1".equals(binaryString.charAt(i)+"")) {
				num++;
			}
		}
        return num;
    }
}