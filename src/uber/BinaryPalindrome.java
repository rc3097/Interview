package uber;

/*
 * 
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189228&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 第一道是给一个32位的int数，你判断它的2进制表示是否是palindrome,我自己是高位和地位两边一起移动看收尾字符是否是相同的，后来网上有大牛说可以做查询表或者把低16位翻转，左移16位，然后让高16位右移16位，两个部分or一下，看和原来数据是否一样。
 */

public class BinaryPalindrome {

	public boolean checkPalindrome(int num) {
		String s = Integer.toBinaryString(num);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryPalindrome q = new BinaryPalindrome();
		System.out.println(q.checkPalindrome(4));
		System.out.println(q.checkPalindrome(7));
		System.out.println(q.checkPalindrome(3));
	}

}
