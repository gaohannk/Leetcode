package company.smartnews.oa;

import java.util.HashMap;

// leetcode 904
public class Problem6 {
    public static int totalFruit(int[] tree) {
        if (tree.length == 1) {
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int p1 = 0, p2 = 1;
        map.put(tree[p1], 1);
        int max = 0;
        while (p2 < tree.length) {
            map.put(tree[p2], map.getOrDefault(tree[p2], 0) + 1);
            while (map.keySet().size() > 2) {
                map.put(tree[p1], map.get(tree[p1]) - 1);
                if (map.get(tree[p1]) == 0) {
                    map.remove(tree[p1]);
                }
                p1++;
            }
            max = Math.max(max, p2 - p1 + 1);
            p2++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
//        int[] tree = {1,2,3,2,2};
//        int[] tree = {1,2,1};
        System.out.println(totalFruit(tree));
    }
}
