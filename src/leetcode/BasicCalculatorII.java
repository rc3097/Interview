package leetcode;
import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
		s = s.replace(" ", "");
		if (s.length()==0) return 0;
		Stack<Character> signStack = new Stack<Character>();
		Stack<Integer> numStack = new Stack<Integer>();
		String prenum = "";
		for (int i = 0; i < s.length(); i++) {
			char currchar = s.charAt(i);
			if (currchar<='9' && currchar>='0') {
				prenum +=currchar; 
			} else {
				if (prenum.length()!=0) {
					numStack.push(Integer.valueOf(prenum));
					prenum="";
				} 
				if (currchar=='(') {
					signStack.push(currchar);
				} else if (currchar==')') {
					while (!signStack.isEmpty() && signStack.peek()!='(') {
                        stackcalculator(signStack,numStack);
                    }
                    signStack.pop();
				} else if (currchar=='+' || currchar=='-') {
					while (!signStack.isEmpty() && signStack.peek()!='(' ) {
						stackcalculator(signStack,numStack);
					}
					signStack.push(currchar);
				} else if (currchar =='*' || currchar== '/') {
					while (!signStack.isEmpty() && (signStack.peek()=='*' || signStack.peek()=='/')) {
						stackcalculator(signStack,numStack);
					}
					signStack.push(currchar);
				}
				
			}
		}
		if (prenum.length()!=0) {
			numStack.push(Integer.valueOf(prenum));
		}
        while (!signStack.isEmpty()) {
            stackcalculator(signStack,numStack);
        }
        return numStack.pop();
	}

	private void stackcalculator(Stack<Character> signStack,
			Stack<Integer> numStack) {
		// TODO Auto-generated method stub
		char sign = signStack.pop();
        int num2= numStack.pop();
        int num1 = numStack.pop();
        if (sign == '*') {
            numStack.push(num1*num2);
        } else if (sign == '-') {
            numStack.push(num1-num2);
        } else if (sign=='+') {
            numStack.push(num1+num2);
        } else if (sign == '/'){
            numStack.push(num1/num2);
        }
	}
}