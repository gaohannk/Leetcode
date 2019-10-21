package leetcode;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class ReconstructItinerary {
    // key: depart, value: list of arrive
    Map<String, Queue<String>> orderedmap = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, String> ordered = new HashMap<>();
        Set<String> airports = new HashSet<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> item = tickets.get(i);
            String depart = item.get(0);
            String arrive = item.get(1);
            if (orderedmap.get(depart) == null) {
                orderedmap.put(depart, new PriorityQueue<>(Comparator.naturalOrder()));
            }
            orderedmap.get(depart).add(arrive);
        }
        dfs("JFK", tickets.size() + 1);
        return res;

    }

    public boolean dfs(String start, int total) {

        //look for a complete traversal
        if (res.size() == total)
            return true;
        if (orderedmap.get(start) == null)
            return false;

        //remember options
        PriorityQueue<String> branches = new PriorityQueue<>(orderedmap.get(start));

        while (branches.size() > 0) {
            String branch = branches.poll();
            // branches already diverge from orderedmap.get(start)
            orderedmap.get(start).remove(branch);
            res.add(start);
            if (dfs(branch, total))
                return true;
            res.remove(start);
            //back fill this dead branch to selection
            orderedmap.get(start).add(branch);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
