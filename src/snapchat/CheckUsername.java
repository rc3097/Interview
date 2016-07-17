package snapchat;
import java.util.*;
/*
 * 检测不合法username。
不合法条件：1. 输入username和"snapchat"之间只有一字符差别；
                       2. 输入username相当于在“snapchat"基础上插入1个字符；
                       3. 输入username相当于在“snapchat"基础上减少1个字符。
    满足上述条件任一，为不合法username。
    Follow-up: 比较字符串从”snapchat“改为任意。
*/

public class CheckUsername {
	public boolean check(String s, String t) {
		int m = s.length(); int n = t.length();
		// m is larger
		if (m<n) return check(t,s);
		if (m-n>1) return false;
		int i=0;
		while (i<n && s.charAt(i)==t.charAt(i)) i++;
		int shift = m-n;
		if (i==n) return shift>0;
		if (shift==0) i++;
		while (i<n && s.charAt(i+shift)==t.charAt(i)) i++;
		return i==n;
	}
	public static void main(String[] args) {
		CheckUsername q = new CheckUsername();
		System.out.println(q.check("snapchar","snapchat")); //T
		System.out.println(q.check("snapchar","snapchar"));//F
		System.out.println(q.check("snapchar","snapchat1"));//F
		System.out.println(q.check("snapchar","1snapchat"));//F
		System.out.println(q.check("snapchat","snapcha"));//F

	}
}