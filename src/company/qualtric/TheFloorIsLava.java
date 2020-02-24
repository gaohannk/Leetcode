package company.qualtric;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/338404/Qualtrics-or-Phone-screen-or-The-Floor-is-Lava
 */
public class TheFloorIsLava {
    public static boolean canReach(float[][] points, int start_index, int end_index, float J) {
        boolean[] visited = new boolean[points.length];
        Queue<float[]> queue = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();

        queue.offer(points[start_index]);
        indexQ.offer(start_index);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                float[] cur = queue.poll();
                int index = indexQ.poll();
                if (index == end_index) {
                    return true;
                }
                visited[index] = true;
                for (int j = 0; j < points.length; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (isReachable(cur, points[j], J)) {
                        queue.offer(points[j]);
                        indexQ.offer(j);
                    }
                }
            }
        }
        return false;
    }

    public static boolean isReachable(float[] start, float[] end, float J) {
        double dis = Math.sqrt(Math.pow(start[0] - end[0], 2) + Math.pow(start[1] - end[1], 2));
        return dis <= J;
    }

    public static void main(String[] args) {
//        float[][] pointes = new float[][]{{1, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {3, 4}, {4, 2}, {4, 1}, {5, 1}, {5, 0}};
        float[][] pointes = new float[][]{{1, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {3, 4}, {4, 1}, {5, 1}, {5, 0},};

        System.out.println(canReach(pointes, 0, 8 , 1));

    }
}
