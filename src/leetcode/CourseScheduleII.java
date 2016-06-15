package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class CourseScheduleII {
	   public int[] findOrder(int numCourses, int[][] prerequisites) {
	        HashMap<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
	        HashMap<Integer, HashSet<Integer>> edges = new  HashMap<Integer, HashSet<Integer>>();
	        buildmap(prerequisites,numCourses,indegrees, edges);
	        
	        Queue<Integer> queue= new LinkedList<Integer>();
	        for (int i=0; i<numCourses; i++) {
	            if (indegrees.get(i)==0)
	                queue.add(i);
	        }
	        int[] courses = new int[numCourses];
	        int count = 0;
	        while (!queue.isEmpty()) {
	            int from = queue.poll();
	            courses[count]=from;
	            count++;
	            for (int to:edges.get(from)) {
	                int prev_d = indegrees.get(to);
	                prev_d--;
	                indegrees.put(to,prev_d);
	                if (prev_d==0) {
	                    queue.add(to);
	                } 
	            }
	        }
	        if (count!=numCourses) {
	            return new int[0];
	        }
	        return courses;
	    }
	    
	    private void buildmap(int[][] prerequisites, int numCourses, 
	            HashMap<Integer, Integer> indegrees, HashMap<Integer, HashSet<Integer>> edges) {
	        for (int i = 0; i<numCourses; i++) {
	            edges.put(i, new HashSet<Integer>());
	            indegrees.put(i,0);
	        }
	        
	        for (int[] prerequisite: prerequisites) {
	            int from = prerequisite[1];
	            int to = prerequisite[0];
	            if (!edges.get(from).contains(to)) {
	            	indegrees.put(to,indegrees.get(to)+1);
	            	edges.get(from).add(to);
	            }
	        }
	    }
	}