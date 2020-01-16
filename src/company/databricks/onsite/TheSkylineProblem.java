package company.databricks.onsite;

import java.util.*;

/*A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
*/
public class TheSkylineProblem {
    class Node {
        int x;
        int height;
        char type;

        public Node(int x, int height, char type) {
            this.x = x;
            this.height = height;
            this.type = type;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    return o1.type - o2.type;
                }
            }
        });

        for (int[] building : buildings) {
            Node starNode = new Node(building[0], building[2], 's');
            Node endNode = new Node(building[1], building[2], 'e');
            queue.add(starNode);
            queue.add(endNode);
        }
        int maxHeight = 0;
        List<List<Integer>> res = new LinkedList<>();
        Queue<Integer> height = new PriorityQueue<>(Comparator.reverseOrder());
        height.add(0);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.type == 's') {
                height.add(cur.height);
                if (maxHeight < cur.height) {
                    maxHeight = cur.height;
                    List<Integer> critialPoint = new LinkedList<>();
                    critialPoint.add(cur.x);
                    critialPoint.add(cur.height);
                    res.add(critialPoint);
                }
                height.offer(cur.height);
            } else {
                if (cur.height == maxHeight) {
                    height.poll();
                    //Output:
                    //[[0,3],[2,0],[2,3],[5,0]]
                    //Expected:
                    //[[0,3],[5,0]]
                    if (!height.peek().equals(res.get(res.size() - 1).get(1))) {
                        List<Integer> critialPoint = new LinkedList<>();
                        critialPoint.add(cur.x);
                        critialPoint.add(height.peek());
                        System.out.println(height.peek());
                        res.add(critialPoint);
                    }
                    maxHeight = height.peek();
                } else {
                    height.remove(cur.height);
                }
            }
        }
        for (int i = 1; i < res.size(); ) {
            //Output
            //[[1,1],[1,3],[2,0]]
            //Expected
            //[[1,3],[2,0]]
            if (res.get(i).get(0).equals(res.get(i - 1).get(0))) {
                res.remove(i - 1);
            } else {
                i++;
            }
        }
        return res;
    }
}
