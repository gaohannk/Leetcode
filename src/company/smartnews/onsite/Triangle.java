package company.smartnews.onsite;

import java.util.*;
import java.util.stream.Collectors;

public class Triangle {
    /**
     * duplicate
     * @param input
     * @return
     */
    public static List<int[]> findTriangle(int[][] input) {
        List<int[]> res = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            int x = input[i][0];
            int y = input[i][1];
            int z = input[i][2];
            if (x + y > z && y + z > x && x + z > y) {
                res.add(input[i]);
            }
        }
        return res;
    }

    /**
     * No duplicate
     * @param input
     * @return
     */
    public static List<int[]> findTriangle2(int[][] input) {
        List<int[]> res = new LinkedList<>();

        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            Arrays.sort(input[i]);
            int x = input[i][0];
            int y = input[i][1];
            int z = input[i][2];
            boolean flag = false;
            if (x + y > z && y + z > x && x + z > y) {
                for (List<Integer> s : set) {
                    if (s.get(0) == x && s.get(1) == y && s.get(2) == z) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    res.add(input[i]);
                    set.add(Arrays.asList(x, y, z));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {2, 3, 4},
                {1, 1, 2},
                {5, 5, 6},
                {5, 6, 5}
        };
        List<int[]> res = findTriangle(input);
        List<int[]> res2 = findTriangle2(input);

        for (int[] a : res2) {
            System.out.print(a[0] + " ");
            System.out.print(a[1] + " ");
            System.out.println(a[2] + " ");
        }
    }
}
