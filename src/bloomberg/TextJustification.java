package bloomberg;

import java.util.*;

public class TextJustification {
 	public List<String> fullJustify(String[] words, int maxWidth) {
 		List<String> res = new ArrayList();
 		int idx = 0;
 		while (idx<words.length) {
 			int len = words[idx].length();
 			String str = words[idx];
 			ArrayList<String> wordlist = new ArrayList();
 			while (idx+1<words.length && len+words[idx+1].length()+1<maxWidth) {
 				len+= words[++idx].length()+1;
 				wordlist.add(words[idx]);
 			}
 			if (wordlist.size()==0) {
 				while (str.length()<maxWidth) str+=" ";
 				
 			} else {
 				int space = (maxWidth - len)/wordlist.size();
 				int extraspace = (maxWidth - len) % wordlist.size();
 				String strspace = " ";
 				for (int i=0; i<space;i++) strspace+=" ";
 				for (String word : wordlist) {
 					if (extraspace>0) {
 						str+=strspace + " "+word;
 						extraspace--;
 					} else {
 						str+=strspace+word;
 					}
 				}
 			}
 			idx++;
 			res.add(str);
 		}
 		return res;
 	}

 	public static void main(String[] args) {
 		TextJustification q = new TextJustification();
 		System.out.println(q.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
 	}
 }