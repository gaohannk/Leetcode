package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 * Example 2:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * Example 3:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 * <p>
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * <p>
 * Output:
 * true
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int org[], int[][] seqs) {
        if (org == null || seqs == null || org.length == 0 || seqs.length == 0)
            return false;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > org.length)
                    return false;
                if (i < seq.length - 1) {
                    if (map.get(seq[i]) == null)
                        map.put(seq[i], new HashSet<>());
                    else
                        map.get(seq[i]).add(seq[i + 1]);
                }
            }
        }
        for (int i = 0; i < org.length - 1; i++) {
            if (!map.get(org[i]).contains(org[i + 1]))
                return false;
        }
        return map.get(org[org.length - 1]) == null;
    }
}
