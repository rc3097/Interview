package leetcode;
import java.util.Stack;

public class Googletest2 {

	private class Folder {
		boolean iscount = false;
		String foldername = "";

		public Folder(String foldername) {
			this.foldername = foldername;
		}
	}

	public int solution(String S) {
		// write your code in Java SE 8
		String[] Sarr = S.split("\n");
		Stack<Folder> dirStack = new Stack<Folder>();
		int result = 0;
		int currlen = 0;
		for (String string : Sarr) {
			int space = 0;
			while (space < string.length() && string.charAt(space) == ' ') {
				space++;
			}
			string = string.replace(" ", "");
			string = string+"?";
			if (string.contains(".jpeg") || string.contains(".png")
					|| string.contains(".gif")) {
				if (!dirStack.peek().iscount) {
					result += currlen;
					dirStack.peek().iscount = false;
				}
			} else if (string.contains(".")) {
				continue;
			} else if (space > dirStack.size()-1) {
				dirStack.push(new Folder(string));
				currlen += string.length();
			} else if (space < dirStack.size()-1) {
				while (space < dirStack.size()) {
					Folder folder = dirStack.pop();
					currlen -= (folder.foldername.length());
				}
				dirStack.push(new Folder(string));
				currlen += (string.length());
			} else {
				if (!dirStack.isEmpty()) {
					Folder folder = dirStack.pop();
					currlen -= (folder.foldername.length());
				}
				dirStack.push(new Folder(string));
				currlen += (string.length());
			}

		}
		return result;
	}
}