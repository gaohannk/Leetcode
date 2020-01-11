package company.hired;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static long solution(long[] tree) {
        if (tree.length == 0) {
            return 0L;
        }
        Queue<Long> queue = new LinkedList<>();
        queue.add(tree[0]);
        int count = 1;
        int i = 1;
        int res = 1;
        while (!queue.isEmpty()) {
            Queue<Long> nextLayer = new LinkedList<>();
            count = count * 2;
            int nextCount = 0;
            while (count > 0 && i < tree.length) {
                if (tree[i] != -1) {
                    nextCount++;
                }
                nextLayer.add(tree[i]);
                i++;
                count--;
            }
            if (i >= tree.length) {
                break;
            }
            count = nextCount;
            queue = nextLayer;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        long[] tree = new long[]{1, 2, 3, 4, -1, -1, -1};
        long[] tree = new long[]{1, 2, -1, -1, 3, 4, -1, -1, 5};

        System.out.println(solution(tree));
    }
}
