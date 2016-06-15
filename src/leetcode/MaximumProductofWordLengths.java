package leetcode;
import java.util.Arrays;
import java.util.Comparator;


public class MaximumProductofWordLengths {
	   private class Word {
	        int len;
	        int[] cmap = new int[26];
	        public Word(String word) {
	            len = word.length();
	            for (int i=0; i<len;i++){
	                cmap[word.charAt(i)-'a']=1;
	            }
	        }

	        public boolean equals(Word c) {
	            for (int i=0;i<26;i++) {
	                if (cmap[i]>0 && c.cmap[i]>0) return true;
	            }
	            return false;
	        }
	    }
	    public int maxProduct(String[] words) {
	        int n = words.length;
	        Word[] newwords = new Word[n];
	        Arrays.sort(words, new Comparator<String>() {
	            public int compare(String o1,String o2) {
	                return o2.length()-o1.length();
	        }});
	        for (int i =0;i<n;i++) {
	            newwords[i] = new Word(words[i]);
	        }
	        
	        int max = 0;
	        for (int i =0; i<n;i++) {
	            for (int j =i+1;j<n;j++) {
	                if (!newwords[i].equals(newwords[j])) {
	                    max = Math.max(max,newwords[i].len*newwords[j].len);
	                    break;
	                }
	            }
	        }
	        return max;
	    } 
	}