package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList();
        if(tickets == null || tickets.length == 0){
            return result;
        }

        Map<String, ArrayList<String>> graph = new HashMap();
        for(int i=0; i<tickets.length; i++){
            if(!graph.containsKey(tickets[i][0])){
                ArrayList<String> adj = new ArrayList();
                adj.add(tickets[i][1]);
                graph.put(tickets[i][0], adj);
            }else{
                ArrayList<String> newadj = graph.get(tickets[i][0]);
                newadj.add(tickets[i][1]);
                graph.put(tickets[i][0], newadj);
            }
        }

        for(ArrayList<String> a : graph.values()){
            Collections.sort(a);
        }

        backtracing(result, "JFK", graph);

        return result;
    }

    public void backtracing(List<String> result, String current, Map<String, ArrayList<String>> graph){
        while(graph.containsKey(current) && !graph.get(current).isEmpty()){
            String s = graph.get(current).remove(0);
            backtracing(result, s, graph);
        }
        result.add(0,current);
    }
}