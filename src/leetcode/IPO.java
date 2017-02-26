package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * <p>
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 * <p>
 * Example 1:
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * <p>
 * Output: 4
 * <p>
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Note:
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Profits == null || Capital == null) {
            return 0;
        }
        ArrayList<Pair> projects = new ArrayList<>();
        for (int i = 0; i < Profits.length; i++) {
            projects.add(new Pair(Profits[i], Capital[i]));
        }
        // sort all the project with capital ascending order
        // make it convenient to check all the projects that satisfy current capital constrain
        Collections.sort(projects, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                int diff = p1.cap - p2.cap;
                if (diff == 0) {
                    diff = p2.prf - p1.prf;
                }
                return diff;
            }
        });

        // maxheap : always garantee that the top of pq has maximual profit
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                int diff = p2.prf - p1.prf;
                if (diff == 0) {
                    diff = p1.cap - p1.cap;
                }
                return diff;
            }
        });

        // the potential project we start to look at
        int i = 0;
        // loop for k round
        while (k > 0) {
            // initialization for each round
            // put all the projects that satisfy current capital constrain into PQ
            while (i < projects.size() && projects.get(i).cap <= W) {
                pq.add(projects.get(i));
                i++;
            }
            // the top of PQ would be our best choice of this round
            if (!pq.isEmpty()) {
                W += pq.poll().prf;
            }
            k--;
        }
        return W;
    }
}

class Pair {
    int prf;
    int cap;

    public Pair(int prf, int cap) {
        this.prf = prf;
        this.cap = cap;
    }
}