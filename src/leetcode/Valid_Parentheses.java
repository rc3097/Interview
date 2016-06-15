package leetcode;
import java.util.Stack;


public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Integer> type1 = new Stack<Integer>();
        Stack<Integer> type2 = new Stack<Integer>();
        Stack<Integer> type3 = new Stack<Integer>();
        type1.push(-1);
        type2.push(-1);
        type3.push(-1);
        for (int i=0; i<s.length();i++) {
            if (s.charAt(i)=='(' ) {
                type1.push(i);
            }
            if (s.charAt(i)=='{' ) {
                type3.push(i);
            }
            if (s.charAt(i)=='[' ) {
                type2.push(i);
            }
            if (s.charAt(i)==')') {
                if (type1.size()<=1) {
                    return false;
                }
                if (type1.peek()>type2.peek() && type1.peek()>type3.peek()) {
                    type1.pop();
                } else {
                    return false;
                }
            }
            if (s.charAt(i)==']') {
                if (type2.size()<=1) {
                    return false;
                }
                if (type2.peek()>type1.peek() && type2.peek()>type3.peek()) {
                    type2.pop();
                } else {
                    return false;
                }
            }
            if (s.charAt(i)=='}') {
                if (type3.size()<=1) {
                    return false;
                }
                if (type3.peek()>type1.peek() && type3.peek()>type2.peek()) {
                    type3.pop();
                } else {
                    return false;
                }
            }
        }
        if (type1.size()!=1 || type2.size()!=1 || type3.size()!=1) {
        	return false;
        }
        return true;
    }
}