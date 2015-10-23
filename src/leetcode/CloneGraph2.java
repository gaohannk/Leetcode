package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* Solution 2 DFS
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

	public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node) {
		if (node == null)
			return;

		for (UndirectedGraphNode aneighbor : node.neighbors) {
			if (!hm.containsKey(aneighbor)) {
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
				hm.put(aneighbor, newneighbor);
				DFS(hm, aneighbor);// DFS
			}
			hm.get(node).neighbors.add(hm.get(aneighbor));
		}
	}
}
