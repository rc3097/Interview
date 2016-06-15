package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WordDistance {
	   private HashMap<String,List<Integer>> wordMap = new HashMap<String,List<Integer>>();
	    private HashMap<String,HashMap<String, Integer>> dictMap = new HashMap<String,HashMap<String, Integer>>();
	    public WordDistance(String[] words) {
	        for (int i = 0; i<words.length;i++) {
	            if (!wordMap.containsKey(words[i])) {
	                wordMap.put(words[i], new ArrayList<Integer>());
	            }
	            wordMap.get(words[i]).add(i);
	        }
	    }

	    public int shortest(String word1, String word2) {
	        if (word1.compareTo(word2)>0) {
	            String temp = word1;
	            word1 = word2;
	            word2= temp;
	        }
	        if (dictMap.containsKey(word1) && dictMap.get(word1).containsKey(word2)) return dictMap.get(word1).get(word2);
	        int min = Integer.MAX_VALUE;
	        for (int i :  wordMap.get(word1)) {
	            for (int j: wordMap.get(word2)) {
	                min = Math.min(min,Math.abs(i-j));
	            }
	        }
	        if (!dictMap.containsKey(word1)) {
	            dictMap.put(word1,new HashMap<String,Integer>());
	        }
	        if (!dictMap.get(word1).containsKey(word2)) {
	            dictMap.get(word1).put(word2,0);
	        }
	        dictMap.get(word1).put(word2,min);
	        return min;
	    }
	}