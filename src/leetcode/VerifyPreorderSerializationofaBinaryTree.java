package leetcode;
import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
	public boolean isValidSerialization(String preorder) {
		Stack<String> stack = new Stack<String>();
		String[] words = preorder.split(",");
		for (int i = 0; i < words.length; i++) {
			String ch = words[i];
			if (ch.equals("#")) {
				if (!stack.isEmpty() && stack.peek().equals("#")) {
					while (!stack.isEmpty() && stack.peek().equals("#")) {
						stack.pop();
						if (stack.isEmpty()|| stack.peek().equals("#"))
							return false;
						stack.pop();
					}
				} 
				stack.push("#");
			} else {
				stack.push(ch);
			}
		}
		if (stack.size()==1 && stack.peek().equals("#"))
			return true;
		return false;
	}
}