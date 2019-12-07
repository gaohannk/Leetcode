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
 *
 * Then, A[i][0] and A[i] are monotone increasing, so we can binary search on them to find the most recent vote by time.
 */
public class OnlineElection {
    class TopVotedCandidate {
        //index 0 is the time and index 1 is the winner
        List<int[]> winners;
        Map<Integer, Integer> map;

        public TopVotedCandidate(int[] persons, int[] times) {
            winners = new ArrayList<>();
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            int winner = Integer.MIN_VALUE;
            for (int i = 0; i < persons.length; ++i) {
                int count = map.getOrDefault(persons[i], 0) + 1;
                if (count >= max) {
                    max = count;
                    winner = persons[i];
                }
                map.put(persons[i], count);
                winners.add(new int[]{times[i], winner});
            }
        }

        public int q(int t) {
            int start = 0;
            int end = winners.size() - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int[] timePerson = winners.get(mid);
                if (timePerson[0] < t) {
                    start = mid + 1;
                } else if (timePerson[0] == t) {
                    return timePerson[1];
                } else {
                    end = mid - 1;
                }
            }
            return winners.get(start - 1)[1];
        }
    }
}
