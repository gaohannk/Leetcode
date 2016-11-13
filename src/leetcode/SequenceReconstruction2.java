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

/**
 * For org to be uniquely reconstructible from seqs we need to satisfy 2 conditions:
 * 1. Every sequence in seqs should be a subsequence in org. This part is obvious.
 * 2. Every 2 consecutive elements in org should be consecutive elements in some sequence from seqs.
 * Why is that? Well, suppose condition 1 is satisfied. Then for 2 any consecutive elements x and y in org we have 2 options.
 * We have both x and y in some sequence from seqs. Then (as condition 1 is satisfied) they must be consequtive elements in this sequence.
 * There is no sequence in seqs that contains both x and y. In this case we cannot uniquely reconstruct org from seqsas sequence with x and y switched would also be a valid original sequence for seqs.
 */
public class SequenceReconstruction2 {
    public boolean sequenceReconstruction(int org[], int[][] seqs) {
        if (org == null || seqs == null || org.length == 0 || seqs.length == 0)
            return false;
        int index[] = new int[org.length];
        for (int i = 0; i < org.length; i++) {
            index[org[i]] = i;
        }
        HashSet<int[]> edgeSet = new HashSet<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length - 1; i++) {
                // check
                if (seq[i] < 0 || seq[i] > org.length)
                    return false;
                // check seq element in org index order
                if (index[seq[i]] > index[seq[i + 1]])
                    return false;
                edgeSet.add(new int[]{seq[i], seq[i + 1]});
            }
        }
        for (int i = 0; i < org.length - 1; i++) {
            boolean flag = true;
            for (int[] item : edgeSet) {
                if (item[0] == org[i] && item[1] == org[i + 1])
                    flag = false;

            }
            if (flag)
                return false;
        }
        return true;
    }
}
