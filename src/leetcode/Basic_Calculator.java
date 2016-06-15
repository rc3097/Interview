package leetcode;
import java.util.ArrayList;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class Basic_Calculator {
	public int calculate(String s) {
		s = s.replace(" ", "");
		s = "0+" + s;
		Stack<String> expression = new Stack<String>();
		// true is plus
		String prenum = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
				if (prenum != "") {
					expression.push(prenum);
				}
				prenum = "";
				expression.push(s.charAt(i) + "");
			} else if (s.charAt(i) == ')') {
				if (prenum != "") {
					expression.push(prenum);
				}
				prenum = "";
				ArrayList<String> subexpStrings = new ArrayList<String>();
				while (!expression.peek().equals("(")) {
					subexpStrings.add(0, expression.pop());
				}
				expression.pop();
				expression.push(String.valueOf(cal(subexpStrings)));
			} else {
				prenum += s.charAt(i);
			}
		}
		if (prenum.length() != 0)
			expression.push(prenum);
		ArrayList<String> subexpStrings = new ArrayList<String>();
		while (!expression.isEmpty()) {
			subexpStrings.add(0, expression.pop());
		}
		return cal(subexpStrings);

	}

	private int cal(ArrayList<String> subexpStrings) {
		int result = Integer.valueOf(subexpStrings.get(0));
		for (int i = 1; i < subexpStrings.size() - 1; i += 2) {
			if (subexpStrings.get(i).equals("+")) {
				result += Integer.valueOf(subexpStrings.get(i + 1));
			} else if (subexpStrings.get(i).equals("-")) {
				result -= Integer.valueOf(subexpStrings.get(i + 1));
			}
		}
		return result;
	}
}