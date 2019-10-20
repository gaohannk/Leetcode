package leetcode.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        // map for student ID -> student scores in a max pq
        Map<Integer, PriorityQueue<Integer>> scores = new HashMap<>();
        // pq for a single student
        PriorityQueue<Integer> student;
        for (int[] i : items) {
            // retreive or create score pq for current student
            student = scores.getOrDefault(i[0], new PriorityQueue<>(Collections.reverseOrder()));
            student.offer(i[1]);
            scores.put(i[0], student);
        }
        int[][] res = new int[scores.size()][2];
        for (int i = 1; i <= res.length; i++) {
            student = scores.get(i);
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                // get highest five scores
                sum += student.poll();
            }
            // ID - 1 for the index
            res[i - 1] = new int[]{i, sum / 5};
        }
        return res;
    }
}
