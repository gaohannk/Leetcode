package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph3 {
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

		HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		hm.put(node, head);
		stack.push(node);

		while (!stack.isEmpty()) {
			UndirectedGraphNode curnode = stack.pop();
			for (UndirectedGraphNode aneighbor : curnode.neighbors) {
				if (!hm.containsKey(aneighbor)) {
					// if not visited,then push to stack
					stack.push(aneighbor);
					UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
					hm.put(aneighbor, newneighbor);
				}

				hm.get(curnode).neighbors.add(hm.get(aneighbor));
			}
		}

		return head;
	}
}
