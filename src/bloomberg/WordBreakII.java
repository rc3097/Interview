package bloomberg;

import java.util.*;
public class WordBreakII {
    HashMap<String, ArrayList<String>> mem = new HashMap();
	public List<String> wordBreak(String s, Set<String> wordDict) {
	    if (mem.containsKey(s)) return mem.get(s);
	    ArrayList<String> res = new ArrayList();
	    
	    if (wordDict.contains(s)) res.add(s);
	    for (int i =1; i<= s.length();i++) {
	        String substr = s.substring(0,i);
	        if (wordDict.contains(substr)) {
	            List<String> temp = wordBreak(s.substring(i),wordDict);
	            for (String str : temp) {
	                res.add(substr+" "+str);
	            }
	        }
	    }
	    mem.put(s,res);
	    return res;
	}
	
}