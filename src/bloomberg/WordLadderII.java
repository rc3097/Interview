public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		
		HashMap<String,ArrayList<ArrayList<String>>> wordMap = new HashMap();
		ArrayList<ArrayList<String>> beginlist = new ArrayList();
		ArrayList<String> beginsublist = new ArrayList();
		beginsublist.add(beginWord);
		beginlist.add(beginsublist);
		wordMap.put(beginWord, beginlist);

		Queue<String> queue = new LinkedList<String>();
		while (!queue.isEmpty()) {
			String start = queue.poll();
			if (start.equals(endWord)) {
				break;
			}
			char[] schr = start.toCharArray();

			for (int i=0; i< schr.length();i++) {
				char temp = schr[i];
				for (char c='a'; c<='z'; c++) {
					if (temp==c) continue;
					schr[i] = c;
					String newstr = new String(schr);
					if (wordList.contains(newstr)) {
						ArrayList<ArrayList<String>> oldList= new ArrayList();
						if (wordMap.containsKey(newstr)) {
							if (wordMap.get(start).get(0).size()+1==wordMap.get(newstr).get(0).size()) {
								oldList =  wordMap.get(newstr);
							} else {
								continue;
							}
						} 
						for (ArrayList<String> sublist: wordMap.get(start)) {
							ArrayList<String> tempsublist = new ArrayList(sublist);
							tempsublist.add(newstr);
							oldList.add(tempsublist);
						}
						wordMap.put(newstr,oldList);
					}
				}
				schr[i]=temp;
			}
			return wordMap.containsKey(endWord)?wordMap.get(endWord):new ArrayList<List<String>>();
		}
	}
}