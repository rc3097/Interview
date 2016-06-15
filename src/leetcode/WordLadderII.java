package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class WordLadderII {
    public class Word {
        List<List<String>> paths = new ArrayList<List<String>>();
        String s = "";
        int len = 0;
        public Word(String s, int len) {
            this.s = s;
            this.len = len;
        }
        
        public void addPaths(List<List<String>> paths) {
            for (List<String> path: paths) {
                ArrayList<String> temppath = new ArrayList<String>(path);
                temppath.add(this.s);
                this.paths.add(temppath);
            }
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<Word> queue = new LinkedList<Word>();
        HashMap<String, Word> wordMap = new HashMap<String, Word>();
        wordList.add(endWord);
        
        ArrayList<List<String>> beginpaths = new ArrayList<List<String>>();
        beginpaths.add(new ArrayList<String>());
        
        Word beginword = new Word(beginWord, 1);
        beginword.addPaths(beginpaths);
        wordMap.put(beginWord, beginword);
        queue.add(beginword);

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            if (word.s.equals(endWord)) {
            	return word.paths;
            }
            wordList.remove(word.s);
            
            char[] wchar = word.s.toCharArray();
            for (int i =0; i<wchar.length;i++) {
                char temp = wchar[i];
                for (char c='a'; c<='z';c++) {
                    if (temp==c) continue;
                    wchar[i] = c;
                    String nstr= new String(wchar);
                    if (wordList.contains(nstr)) {
                        Word nword = new Word(nstr, word.len+1);
                        if (wordMap.containsKey(nstr)) {
                            nword = wordMap.get(nstr);
                        } else {
                            queue.add(nword);
                        }
                        if (word.len+1==nword.len) {
                        	nword.addPaths(word.paths);
                        	wordMap.put(nstr,nword);
                        }
                    }
                }
                wchar[i] = temp;
            }
        }
        return beginpaths;
    }
}