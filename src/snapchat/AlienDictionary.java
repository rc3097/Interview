package snapchat;
import java.util.*;
public class AlienDictionary {
	
	public static void main(String[] args) {
		AlienDictionary q = new AlienDictionary();
		System.out.println(q.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
	}
	public String alienOrder(String[] words) {
		HashMap<Character, HashSet<Character>>  map = new HashMap();
		HashMap<Character, Integer> indegreeMap = new HashMap();
		HashSet<Character> zerodegree = new HashSet();

		init(words, zerodegree);
		buildMap(words, map, indegreeMap, zerodegree);

		// topsort
		String res = "";
		Queue<Character> queue = new LinkedList();
		for (Character word: zerodegree) 
			queue.add(word); 
		while (!queue.isEmpty()) {
			Character curstr = queue.poll();
			res += curstr;
			if (!map.containsKey(curstr)) continue;
			for (Character word: map.get(curstr)) {
				indegreeMap.put(word, indegreeMap.get(word)-1);
				if (indegreeMap.get(word)==0) 
					queue.add(word);
					indegreeMap.remove(word);
			}
		}
		return (indegreeMap.size()==0)?res:"";
	}

	private void init(String[] words, HashSet<Character> zerodegree) {
		for (String word: words) {
			for (int i=0; i< word.length();i++){
				zerodegree.add(word.charAt(i));
			}
		}
	}

	private void buildMap(String[] words, 
			HashMap<Character, HashSet<Character>> map, 
			HashMap<Character, Integer> indegreeMap,
			HashSet<Character> zerodegree) {
		String preStr = words[0];
		for (int i = 1; i< words.length; i++) {
			String nextStr = words[i];
			for (int j= 0; j< preStr.length() && j< nextStr.length(); j++) {
				if (preStr.charAt(j)!=nextStr.charAt(j)) {
					HashSet<Character> temp = new HashSet();
					if (map.containsKey(preStr.charAt(j))) 
						temp = map.get(preStr.charAt(j));
					

					int cnt =0;
					zerodegree.remove(nextStr.charAt(j));
					if (indegreeMap.containsKey(nextStr.charAt(j))) 
						cnt =  indegreeMap.get(nextStr.charAt(j));
					if (!temp.contains(nextStr.charAt(j)))
						cnt++;
					indegreeMap.put(nextStr.charAt(j),cnt);
					temp.add(nextStr.charAt(j));
					map.put(preStr.charAt(j), temp);
					break;
				}
				
			}
			preStr = words[i];
		}
	}

}