package bloomberg;

import java.math.BigInteger;
import java.util.ArrayList;




/*
 * 第一轮 technical interview： 面试官 一个亚洲人一个白人。  亚洲人上来让design 和implement object。  user input string ,  
 * object要能分析并return 出 string中   between  0x02 和 0x03 中间的string。 这个题 tricky的部分是 如果第一次的input 没有0x03, 
 * 就要继续read 下一条 input 直到 检测到 0x03.   如果 同一个input中， 出现两次  0x02 ABCD 0x03 0x02 DDBCD 0x03  
 * 那么 就要return arrayList < ABCD , DDBCD>   
 * http://www.1point3acres.com/bbs/thread-193782-1-1.html
 */
public class StringSplit {
	public ArrayList<String> getSubStr(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		String substring = "";
		boolean isStart = false;
		for (int i = 0; i < strs.length; i++) {
			String[] words = strs[i].split(" ");
			for (String word : words) {
				if (isStart == false && word.equals("0x02")) {
					isStart = true;
					substring = "";
				} else if (isStart && word.equals("0x03")) {
					isStart = false;
					res.add(substring.substring(1));
				} else if (isStart && !word.equals("\n")) {
					substring += " " + word;
				}
			}
		}
		return res;
	}
	public static void main(String[] args)  {
		BigInteger a = new BigInteger("123154564564");
		BigInteger b = new BigInteger("-123154564565");
		System.out.println(a.add(b));
		
		
	}
}
