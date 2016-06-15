package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class WordDictionary {
	   private class Trie {
	        char c ;
	        boolean isEnd;
	        HashMap<Character, Trie> dict =  new HashMap<Character, Trie>();
	        public Trie(char c, boolean isEnd) {
	            this.c = c;
	            this.isEnd = isEnd;
	        }
	    }
	    // Adds a word into the data structure.
	    Trie dictMap = new Trie(' ',true);
	    public void addWord(String word) {
	        addWord(word, 0, this.dictMap);
	    }
	    
	    private void addWord(String word, int i, Trie dictMap) {
	        if (i>=word.length()) return;
	        char c = word.charAt(i);
	        Trie nextone = new Trie(c,false);
	        if (dictMap.dict.containsKey(c)) {
	            nextone = dictMap.dict.get(c);
	        }
	        if (i==word.length()-1) {
	            nextone.isEnd = true;
	        }
	        dictMap.dict.put(c, nextone);
	        addWord(word,i+1, nextone);
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return search(word,0,this.dictMap);
	    }
	    private boolean search(String word, int i , Trie dictMap) {
	        char c = word.charAt(i);
	        if (i==word.length()-1) {
	            return ((dictMap.c==c || c=='.')&& dictMap.isEnd)?true:false;
	        }
	        
	        if (c=='.') {
	            for (Map.Entry<Character, Trie> entryset: dictMap.dict.entrySet()) {
	                if (search(word, i+1, entryset.getValue())) {
	                    return true;
	                }
	            }
	        } else {
	            if (dictMap.dict.containsKey(c)) {
	                return search(word,i+1, dictMap.dict.get(c));
	            } else {
	                return false;
	            }
	        }
	        return false;
	    }
	}