package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

public class Q269 {
	private HashMap<Character, HashSet<Character>> chrMap = new HashMap<Character, HashSet<Character>>();
	private HashMap<Character, Integer> degreeMap = new HashMap<Character, Integer>();
	private String results = "";

	public String alienOrder(String[] words) {
		intialize(words);
		buildMap(words, 0, 0, words.length);
		return results;
	}

	private void intialize(String[] words) {
		// TODO Auto-generated method stub
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (!chrMap.containsKey(word.charAt(i))) {
					chrMap.put(word.charAt(i), new HashSet<Character>());
					degreeMap.put(word.charAt(i), 0);
				}
			}
		}
	}

	private void buildMap(String[] words, int index, int begin, int end) {
		char preword = words[begin].charAt(index);
		int prewordidx = begin;
		for (int i = begin; i < words.length; i++) {
			if (preword != words[i].charAt(index)) {
				HashSet<Character> container = chrMap.get(preword);
				if (!container.contains(words[i].charAt(index))) {
					int count = degreeMap.get(preword);
					count++;
					degreeMap.put(preword, count++);
				}

				container.add(words[i].charAt(index));

				preword = words[i].charAt(index);
				prewordidx = i;
				buildMap(words, index + 1, prewordidx, i);
			}
		}
		// don't miss the last one
		buildMap(words, index + 1, prewordidx, words.length);
	}

	private void topologicalSort() {
		Queue<Character> queue = getzerodegree();
		while (queue.size() > 0) {
			char source = queue.poll();
			results+=source;
			HashSet<Character> linkednode = chrMap.get(queue);
			Iterator<Character> keysetIterator = linkednode.iterator();
			while (keysetIterator.hasNext()) {
				char key = keysetIterator.next();
				int degree = degreeMap.get(key);
				degree--;
				degreeMap.put(key, degree);
				if (degree == 0) {
					queue.add(key);
				}
			}
		}
		
		
	}

	private LinkedList<Character> getzerodegree() {
		Iterator<Character> keyiterator = degreeMap.keySet().iterator();
		LinkedList<Character> results = new LinkedList<Character>();
		while (keyiterator.hasNext()) {
			char key = keyiterator.next();
			if (degreeMap.get(key) == 0) {
				results.add(key);
			}
		}
		return results;
	}

}