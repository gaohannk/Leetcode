package company.amazon.oa;

import java.util.*;

/**
 * 2. itemAssociation
 * 给了一些itemAssociation, 如果一个item既在association A里面出现过，又在association B里面出现过，那么就把A和B合并成一个association。求全部合并后最大的association。
 * 如果两个association一样大，返回lexicographic order的第一个。
 * input：String[][] itemAssociation
 * return: String[]
 * example:
 * input:
 * [itemA, itemB]
 * [itemB, itemC]
 * [itemD, itemE]
 * 合并之后：
 * [itemA, itemB, itemC]
 * [itemD, itemE]
 * 第一个有三个item最多，于是返回[itemA, itemB, itemC]
 */
public class ItemAssociate {
    static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            this.parent = new int[size + 1];
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfComponent() {
            int count = 0;
            for (int i = 1; i < parent.length; i++) {
                if (i == parent[i]) {
                    count++;
                }
            }
            return count;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public static List<String> solution(String[][] itemAssociation) {
        Map<Integer, String> idItemMap = new HashMap<>();
        Map<String, Integer> itemIdMap = new HashMap<>();

        int id = 1;
        for (String[] item : itemAssociation) {
            if (!idItemMap.containsValue(item[0])) {
                idItemMap.put(id, item[0]);
                itemIdMap.put(item[0], id);
                id++;
            }
            if (!idItemMap.containsValue(item[1])) {
                idItemMap.put(id, item[1]);
                itemIdMap.put(item[1], id);
                id++;
            }
        }

        UnionFind uf = new UnionFind(idItemMap.keySet().size());
        for (String[] item : itemAssociation) {
            if (!uf.isConnected(itemIdMap.get(item[0]), itemIdMap.get(item[1]))) {
                uf.union(itemIdMap.get(item[0]), itemIdMap.get(item[1]));
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 1; i < id; i++) {
            countMap.put(uf.find(i), countMap.getOrDefault(uf.find(i), 0) + 1);
        }
        int maxfreq = 0;
        Set<Integer> parentId = new HashSet<>();
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > maxfreq) {
                parentId.clear();
                maxfreq = countMap.get(key);
                parentId.add(key);
            } else if (countMap.get(key) == maxfreq) {
                parentId.add(key);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (int parent : parentId) {
            List<String> curAssociate = new LinkedList<>();
            for (int i = 1; i < id; i++) {
                if (uf.find(i) == parent) {
                    curAssociate.add(idItemMap.get(i));
                }
            }
            Collections.sort(curAssociate);
            res.add(curAssociate);
        }
        Collections.sort(res, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return res.get(0);
    }

    public static void main(String[] args) {
        String[][] itemAssociation = new String[][]{
                {"itemA", "itemB"},
                {"itemB", "itemC"},
                {"itemD", "itemE"},
                {"itemD", "itemF"}
        };
        System.out.println(solution(itemAssociation));
    }
}
