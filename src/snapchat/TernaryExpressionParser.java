package snapchat;

import java.util.*;

public class TernaryExpressionParser {
	class BinaryNode {
		public BinaryNode left, right;
		String exp;
		boolean isTrue;
		// T ? T : F ? T ? 1 : 2 : F ? 3 : 4
		public BinaryNode(String exp) {
			this.exp = exp;
			int sep  = exp.indexOf("?");
			if (sep!=-1) {
				String temp = exp.substring(0,sep);
				isTrue = verify(temp);
				String rest_str = exp.substring(sep+1);
				int idx = getSep(rest_str);
				left = new BinaryNode(rest_str.substring(0,idx));
				right = new BinaryNode(rest_str.substring(idx+1));
			} 
		}

		private int getSep(String temp) {
			int cnt=0;
			for (int i = 0 ; i< temp.length();i++) {
				if (cnt==0 && temp.charAt(i)==':') 
					return i;
				if (temp.charAt(i)=='?') cnt++;
				else if (temp.charAt(i)==':') cnt--;
			}
			return temp.length();
		}

		private boolean verify(String exp) {
			if (exp.equals("T")) return true;
			return false;
		}

		public String getResult() { 
			if (isTrue) 
				return left!=null?left.getResult():this.exp;
			else 
				return right!=null?right.getResult():this.exp;
		}
	}
	public String parser(String exp) {
		BinaryNode root = new BinaryNode(exp);
		return root.getResult();
	}

	public static void main(String[] args) {
		TernaryExpressionParser q = new TernaryExpressionParser();
		System.out.println(q.parser("T?T:F?T?1:2:F?3:4"));		
		System.out.println(q.parser("F?T:F?T?1:2:F?3:4"));	
	}
}