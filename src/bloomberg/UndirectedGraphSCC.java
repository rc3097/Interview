package bloomberg;

public class UndirectedGraphSCC {
	public int count(HashMap<Integer, ArrayList<Integer>> map) {
		int[] id = new int[map.size()];
		boolean[] marked = new boolean[map.size()];
		HashMap<Integer,ArrayList<Integer>> copymap = new HashMap(map);
		int count = 0;
		for (int i=0; i< map.size(); i++) {
			if (!marked[i]) {
				dfs(map,i,count++,id,marked);
			}
		}
		return count;
	}

	public void dfs(HashMap<Integer, HashSet<Integer>> map, int cur,int count, int[] id, int[] marked ) {
		if (marked[cur]) return;
		marked[cur]= true;
		id[cur] = count;
		for (Integer node: map.get(cur)) {
			dfs(map,cur,count, id,marked);
		}
	}
}