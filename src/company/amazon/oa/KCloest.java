package company.amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * // 4. 卡车送货的题 (k closest points to origin)
 * // N个地点List<List<Integer>> 地点的坐标, M代表需要送的数量
 * // output：一个List<List<Integer>> 代表送货的地点坐标x,y, 其实就是让你计算距离卡车最近的M个地点.
 * // eg. N = 3, M = 2, List<List<Ingeter>> 是 [[2,3][3,4],[1,-3]]  output: [[2,3],[1,-3]]
 */
public class KCloest {
    public List<List<Integer>> kClosest(List<List<Integer>> points, int K) {
        List<List<Integer>> res = new ArrayList<>();
        //Sort from largest distance to smallest
        PriorityQueue<Node> heap = new PriorityQueue<>(K, Collections.reverseOrder());

        for (List<Integer> point : points) {
            double dis = (Math.pow(point.get(0), 2) + Math.pow(point.get(1), 2));
            Node node = new Node(point.get(0), point.get(1), dis);
            if (heap.size() >= K && dis < heap.peek().dis) {
                heap.poll();
            }
            heap.offer(node);
        }
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            List<Integer> cur = new ArrayList<>();
            cur.add(node.x);
            cur.add(node.y);
            res.add(cur);
        }
        return res;
    }

    class Node {
        int x;
        int y;
        double dis;

        public Node(int x, int y, double dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
