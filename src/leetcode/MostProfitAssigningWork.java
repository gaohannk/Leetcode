package leetcode;

import java.util.*;

/**
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
 * <p>
 * Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
 * <p>
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * <p>
 * For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
 * <p>
 * What is the most profit we can make?
 * <p>
 * Example 1:
 * <p>
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 * Notes:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */

/**
 * Intuition

 We can consider the workers in any order, so let's process them in order of skill.

 If we processed all jobs with lower skill first, then the profit is just the most profitable job we have seen so far.
 */
public class MostProfitAssigningWork {
    class Pair {
        int diff;
        int profit;

        Pair(int diff, int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Pair[] jobs = new Pair[difficulty.length];

        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Pair(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.diff - o2.diff;
            }
        });

        Arrays.sort(worker);
        int idx = 0;
        int maxForCurworker = 0;
        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            while (idx< jobs.length && jobs[idx].diff <= worker[i]) {
                maxForCurworker = Math.max(maxForCurworker, jobs[idx++].profit);
            }
            res += maxForCurworker;
        }
        return res;
    }
}
