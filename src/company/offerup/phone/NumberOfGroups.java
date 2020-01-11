package company.offerup.phone;

import java.util.*;

public class NumberOfGroups {

    public static int numberOfgroups(Map<Integer, List<Integer>> map) {
        Set<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            set.addAll(map.get(key));
            set.add(key);
        }
        UnionFind uf = new UnionFind(set.size() + 1);
        for (Integer key : map.keySet()) {
            for (Integer item : map.get(key)) {
                uf.union(key, item);
            }
        }
        return uf.getComponent() - 1;
    }

    static class UnionFind {

        int[] array;

        UnionFind(int n) {
            array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
            }
        }

        public void union(int i, int j) {
            array[find(i)] = find(j);
        }

        private int find(int i) {
            while (array[i] != i) {
                i = array[i];
            }
            return array[i];
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public int getComponent() {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(2, 3, 4));
        map.put(3, List.of(4, 5));
        map.put(6, List.of(7, 8));
        System.out.println(numberOfgroups(map));
    }
}


