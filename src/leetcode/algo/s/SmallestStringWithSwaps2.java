package leetcode.algo.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwaps2 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] array = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        List<Integer>[] graph = new List[s.length()];
        for (int i = 0; i < array.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> pair : pairs) {
            graph[pair.get(0)].add(pair.get(1));
            graph[pair.get(1)].add(pair.get(0));
        }
        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                List<Integer> indexes = new ArrayList<>();
                List<Character> contents = new ArrayList<>();
                DFS(graph, array, indexes, contents, i, visited);
                Collections.sort(indexes);
                Collections.sort(contents);
                for (int j = 0; j < indexes.size(); j++) {
                    array[indexes.get(j)] = contents.get(j);
                }
            }
        }
        return new String(array);
    }

    private void DFS(List<Integer>[] graph, char[] array, List<Integer> indexes, List<Character> contents, int start, boolean[] visited) {
        visited[start] = true;
        indexes.add(start);
        contents.add(array[start]);
        for (int child : graph[start]) {
            if (!visited[child]) {
                DFS(graph, array, indexes, contents, child, visited);
            }
        }
    }
}
