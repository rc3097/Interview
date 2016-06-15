package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class topSort {
	public ArrayList<DirectedGraphNode> topSort(
			ArrayList<DirectedGraphNode> graph) {
		// write your code here
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> degreeMap = new HashMap<DirectedGraphNode, Integer>();
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

		initialize(degreeMap, graph);
		buildMap(degreeMap, graph);
		getZerodegree(degreeMap, graph, queue);

		while (!queue.isEmpty()) {
			DirectedGraphNode node = queue.poll();
			result.add(node);
			for (DirectedGraphNode child : node.neighbors) {
				int degree = degreeMap.get(child);
				degree--;
				degreeMap.put(child, degree);
				if (degree == 0) {
					queue.add(child);
				}
			}
		}
		return result;
	}

	private void initialize(HashMap<DirectedGraphNode, Integer> degreeMap,
			ArrayList<DirectedGraphNode> graph) {
		for (DirectedGraphNode node : graph) {
			degreeMap.put(node, 0);
		}
	}

	private void buildMap(HashMap<DirectedGraphNode, Integer> degreeMap,
			ArrayList<DirectedGraphNode> graph) {
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode child : node.neighbors) {
				degreeMap.put(child, degreeMap.get(child) + 1);
			}
		}
	}

	private void getZerodegree(HashMap<DirectedGraphNode, Integer> degreeMap,
			ArrayList<DirectedGraphNode> graph, Queue<DirectedGraphNode> queue) {
		for (DirectedGraphNode node : graph) {
			if (degreeMap.get(node) == 0) {
				queue.add(node);
			}
		}
	}
}
