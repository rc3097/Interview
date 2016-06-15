package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class TrieNodeII {
	boolean isSucceed = false;
	HashMap<Character, TrieNodeII> sons;

	// Initialize your data structure here.
	public TrieNodeII() {
		sons = new HashMap<Character, TrieNodeII>();
	}
}

class TrieII {
	public TrieNodeII root;

	public TrieII() {
		// TODO Auto-generated constructor stub
		root = new TrieNodeII();
	}

	public void insert(String word) {
		TrieNodeII temp = root;
		for (int i = 0; i < word.length(); i++) {
			if (temp.sons.containsKey(word.charAt(i))) {
				temp = temp.sons.get(word.charAt(i));
			} else {
				temp.sons.put(word.charAt(i), new TrieNodeII());
				temp = temp.sons.get(word.charAt(i));
			}
		}
	}

	public boolean search(String word) {
		TrieNodeII temp = root;
		for (int i = 0; i < word.length(); i++) {
			temp = temp.sons.get(word.charAt(i));
			if (!temp.isSucceed)
				return false;
		}
		return temp.isSucceed;
	}
}

public class Word_Search_II {
	public List<String> findWords(char[][] board, String[] words) {
		TrieII wordlist = new TrieII();
		for (int i = 0; i < words.length; i++) {
			wordlist.insert(words[i]);
		}
		TrieNodeII root = wordlist.root;

		Iterator<Character> iterator = root.sons.keySet().iterator();
		List<String> resultList = new ArrayList<String>();

		while (iterator.hasNext()) {
			char firstchar = iterator.next();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == firstchar) {
						char temp = board[i][j];
						board[i][j] = ' ';
						DFS(i, j, root.sons.get(firstchar), board);
						board[i][j] = temp;
					}
				}
			}
		}

		for (int i = 0; i < words.length; i++) {
			if (wordlist.search(words[i]) && !resultList.contains(words[i])) {
				resultList.add(words[i]);
			}
		}

		return resultList;
	}

	// DFS
	public boolean DFS(int prex, int prey, TrieNodeII root, char[][] board) {
		// if (!root.isSucceed)
		// return false;
		if (root.sons.isEmpty()) {
			root.isSucceed = true;
			return true;
		}
		root.isSucceed = true;

		int x = prex - 1;
		int y = prey;
		if (x >= 0 && root.sons.containsKey(board[x][y])) {
			char temp = board[x][y];
			board[x][y] = ' ';
			boolean succeed = DFS(x, y, root.sons.get(temp), board);
			board[x][y] = temp;
		}

		x = prex + 1;
		y = prey;
		if (x < board.length && root.sons.containsKey(board[x][y])) {
			char temp = board[x][y];
			board[x][y] = ' ';
			boolean succeed = DFS(x, y, root.sons.get(temp), board);
			board[x][y] = temp;
		}

		x = prex;
		y = prey - 1;
		if (y >= 0 && root.sons.containsKey(board[x][y])) {
			char temp = board[x][y];
			board[x][y] = ' ';
			boolean succeed = DFS(x, y, root.sons.get(temp), board);
			board[x][y] = temp;

		}

		x = prex;
		y = prey + 1;
		if (y < board[x].length && root.sons.containsKey(board[x][y])) {
			char temp = board[x][y];
			board[x][y] = ' ';
			boolean succeed = DFS(x, y, root.sons.get(temp), board);
			board[x][y] = temp;
		}

		// root.isSucceed = false;
		return false;

	}
}
