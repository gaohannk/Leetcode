package leetcode.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* MinDeleteNoMoreThanThree 2 DFS
 */
public class CloneGraph2 {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		map.put(node, head);

		DFS(map, node);// DFS
		return head;
	}

	public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
		if (node == null)
			return;

		for (UndirectedGraphNode aneighbor : node.neighbors) {
			if (!map.containsKey(aneighbor)) {
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
				map.put(aneighbor, newneighbor);
				DFS(map, aneighbor);// DFS
			}
			map.get(node).neighbors.add(map.get(aneighbor));
		}
	}
}
