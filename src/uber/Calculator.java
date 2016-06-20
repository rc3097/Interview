package uber;

import java.util.Stack;

public class Calculator {

	public double calculate(char c, double b, double a) {
		if (c == '+')
			return a + b;
		if (c == '-')
			return a - b;
		if (c == '*')
			return a * b;
		return a / b;
	}

	public double calculate(String s) {
		if (s.charAt(0) == '-')
			s = "0" + s;
		s = "("+s+")";
		Stack<Double> valStack = new Stack<Double>();
		Stack<Character> opStack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int j = i;
				while (j < s.length() && !isSign(s.charAt(j)))
					j++;
				valStack.push(Double.valueOf(s.substring(i, j)));
				i = j - 1;
			} else {
				char sign = s.charAt(i);
				if (sign == '(') {
					opStack.push(sign);
				} else if (sign == '+' || sign == '-') {
					while (!opStack.empty() && (opStack.peek()=='*' || opStack.peek()=='/' || opStack.peek()=='+' || opStack.peek()=='-')) {
						valStack.push(calculate(opStack.pop(),valStack.pop(),valStack.pop()));
					}
					opStack.push(sign);
				} else if (sign == '*' || sign == '/') {
					opStack.push(sign);
				} else if (sign == ')') {
					while (opStack.peek()!='(') {
						valStack.push(calculate(opStack.pop(),valStack.pop(),valStack.pop()));
					}
					opStack.pop();
				}
			}
		}
		return valStack.peek();
	}

	private boolean isSign(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c=='(' || c==')')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate("-1+3*4")); //12
		System.out.println(calculator.calculate("-1+3")); //2
		System.out.println(calculator.calculate("0-1+3")); //2
		System.out.println(calculator.calculate("3-1")); //2
		System.out.println(calculator.calculate("(1+2)*3-4*(5-8)")); //21
		System.out.println(calculator.calculate("1+3")); //4
		System.out.println(calculator.calculate("1+3*4")); //13
		System.out.println(calculator.calculate("1+2*3/4")); //2.5
		System.out.println(calculator.calculate("100*(2+12)-(20+3)*2")); //1354
		
	}
}
