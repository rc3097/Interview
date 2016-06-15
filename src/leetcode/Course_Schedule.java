package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		HashSet<Integer> headerSet = new HashSet<Integer>();
		for (int i = 0; i < numCourses; i++) {
			headerSet.add(i);
		}
		// hashmap
		int[] du=new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			du[prerequisites[i][0]]++;
			if (headerSet.contains(prerequisites[i][0])) {
				headerSet.remove(prerequisites[i][0]);
			}
			if (map.containsKey(prerequisites[i][1])) {
				ArrayList<Integer> temp = map.get(prerequisites[i][1]);
				temp.add(prerequisites[i][0]);
				map.put(prerequisites[i][1], temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(prerequisites[i][0]);
				map.put(prerequisites[i][1], temp);
			}
		}
		// end

		// BFS
		boolean iscircle = false;
		HashSet<Integer> allcourses=new HashSet<Integer>();
		while (headerSet.size()>0) {
			Iterator<Integer> iterator = headerSet.iterator();
			HashSet<Integer> temp=new HashSet<Integer>();
			while (iterator.hasNext()) {
				int head=iterator.next();
				if (map.containsKey(head)) {
				for (int i = 0; i < map.get(head).size(); i++) {
					du[map.get(head).get(i)]--;
					if (du[map.get(head).get(i)]==0) {
						temp.add(map.get(head).get(i));
					}
				}
				}
			}
			allcourses.addAll(headerSet);
			headerSet=temp;
		}
		if (headerSet.size() < 1 && allcourses.size()!=numCourses)
			return false;
		return !iscircle;
	}
}