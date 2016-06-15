package leetcode;
import java.util.HashMap;

class TrieNode {
	boolean isWord = false;
	HashMap<Character, TrieNode> sons;

	// Initialize your data structure here.
	public TrieNode() {
		sons = new HashMap<Character, TrieNode>();
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a woTrie trie = new Trie();
	public void insert(String word) {
		TrieNode treeNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (treeNode.sons.containsKey(word.charAt(i))) {
				treeNode = treeNode.sons.get(word.charAt(i));
			} else {
				TrieNode newNode = new TrieNode();
				treeNode.sons.put(word.charAt(i), newNode);
				treeNode = treeNode.sons.get(word.charAt(i));
			}
		}
		treeNode.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode treeNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (treeNode.sons.containsKey(word.charAt(i))) {
				treeNode = treeNode.sons.get(word.charAt(i));
			} else {
				return false;
			}
		}
		return treeNode.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode treeNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (treeNode.sons.containsKey(prefix.charAt(i))) {
				treeNode = treeNode.sons.get(prefix.charAt(i));
			} else {
				return false;
			}
		}
		return true;
	}
}