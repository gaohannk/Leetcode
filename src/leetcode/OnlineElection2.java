package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * <p>
 * Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 * <p>
 * Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times is a strictly increasing array with all elements in [0, 10^9].
 * TopVotedCandidate.q is called at most 10000 times per test case.
 * TopVotedCandidate.q(int t) is always called with t >= times[0].
 */

/**
 * We can store the votes in a list A of lists of votes. Each vote has a person and a timestamp, and A[count] is a list of the count-th votes received for that person.
 * <p>
 * Then, A[i][0] and A[i] are monotone increasing, so we can binary search on them to find the most recent vote by time.
 */
public class OnlineElection2 {
    class TopVotedCandidate {
        List<Vote> A;
        Map<Integer, Integer> count;

        public TopVotedCandidate(int[] persons, int[] times) {
            A = new ArrayList();
            count = new HashMap();
            int m = 0;  // current number of votes for leader
            int leader = -1;  // current leader

            for (int i = 0; i < persons.length; ++i) {
                int p = persons[i], t = times[i];
                int c = count.getOrDefault(p, 0) + 1;
                count.put(p, c);

                if (c >= m) {
                    if (p != leader) {  // lead change
                        leader = p;
                        // Current time t, we have leader has most vote
                        A.add(new Vote(leader, t));
                    }
                    m = c;
                }
            }
        }

        public int q(int t) {
            int lo = 1, hi = A.size();
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (A.get(mi).time <= t)
                    lo = mi + 1;
                else
                    hi = mi;
            }

            return A.get(lo - 1).person;
        }
    }

    class Vote {
        int person, time;

        Vote(int p, int t) {
            person = p;
            time = t;
        }
    }
}
