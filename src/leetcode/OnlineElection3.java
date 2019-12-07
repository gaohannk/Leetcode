package leetcode;

import java.util.*;
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
public class OnlineElection3 {
    class TopVotedCandidate {

        /**
         * TreeMap contains the times when the leader of the race changed.
         * Key:   Time when the race changed leaders.
         * Value: The new leading candidate.
         */
        private TreeMap<Integer, Integer> winners;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.winners = new TreeMap<Integer, Integer>();
            // Array to keep track of the votes for each candidate, and the maximum number of votes so far.
            int voteCounts[] = new int[persons.length], maxVotes = 0;

            for (int i = 0; i < times.length; i++) {
                voteCounts[persons[i]]++;
                // If this vote makes someone take the lead in the race, update the map.
                if (voteCounts[persons[i]] >= maxVotes) {
                    winners.put(times[i], persons[i]);
                    maxVotes = voteCounts[persons[i]];
                }
            }
        }

        public int q(int t) {
            // floorEntry returns the map entry with the greatest key (time) less than or equal to t.
            // The value of this entry will be the candidate leading the race at time t.
            return winners.floorEntry(t).getValue();
        }
    }
}
