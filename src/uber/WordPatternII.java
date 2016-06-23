package uber;

import java.util.HashMap;
import java.util.HashSet;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap();
        HashSet<String> dictSet = new HashSet<String>();
        return findMatch(map,dictSet, pattern, str);
    }
    
    private boolean findMatch(HashMap<Character, String> map,HashSet<String> dictSet, String pattern, String str) {
        if (pattern.length()==0 && str.length()==0) return true;
        if (pattern.length()==0 || str.length()==0) return false;
        if (map.containsKey(pattern.charAt(0))) {
            String word = map.get(pattern.charAt(0));
            if (str.startsWith(word)) {
                return findMatch(map,dictSet, pattern.substring(1), str.substring(word.length()));
            }
        } else {
            for (int i=1; i<=str.length();i++) {
                String word = str.substring(0,i);
                if (dictSet.contains(word)) continue;
                dictSet.add(word);
                map.put(pattern.charAt(0),word);
                if (findMatch(map,dictSet,pattern.substring(1),str.substring(word.length()))) return true;
                dictSet.remove(word);
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
