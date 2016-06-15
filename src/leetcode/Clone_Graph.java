package leetcode;
import java.util.HashMap;

public class Clone_Graph {
	HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		nodeMap.put(node.label, newNode);
		for (UndirectedGraphNode childnode : node.neighbors) {
			if (nodeMap.containsKey(childnode.label)) {
				newNode.neighbors.add(nodeMap.get(childnode.label));
			} else {
				newNode.neighbors.add(cloneGraph(childnode));
			}
		}
		nodeMap.put(node.label, newNode);
		return newNode;
	}
}
