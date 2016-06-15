package leetcode;
import java.util.LinkedList;
import java.util.List;


public class Solution {

	/**
	 * @param args
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		byte[] Subs=new byte[1048577];
	    LinkedList<String> result = new LinkedList<String>();
	    
        for (int i=0;i<s.length()-9;i++) 
        {
        	String temp=s.substring(i,i+10);
        	int toint=ToBits(temp);
        	if (Subs[toint]!=0) {
        		if (Subs[toint]!=2) {
        			result.add(temp);
        			Subs[toint]=2;
        		}
        	} else {
        		Subs[toint]=1;
        	}
        }
        return result;
    }
	
	int ToBits(String s) {
		int temp=0;
		for (int i=0;i<s.length();i++) {
			temp=temp<<2 | getChartoByte(s.charAt(i));
		}
		return temp;
	}
	int getChartoByte(char c) {
		if (c == 'A') {
			return 0;
		} else if (c == 'C') {
			return 1;
		} else if (c == 'G') {
			return 2;
		}
		return 3;
	}
}
